/*
 *参见 spring官方案例 spring-hateoas-examples
 */
package zy.cy6.zyxt.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zy.cy6.zyxt.api.product.CreateProductCommand;
import zy.cy6.zyxt.api.product.ProductId;
import zy.cy6.zyxt.api.product.ProductName;
import zy.cy6.zyxt.query.product.ProductEntity;
import zy.cy6.zyxt.query.product.ProductQueryService;
import zy.cy6.zyxt.web.product.ProductResourceAssembler;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
// import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
// import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@Slf4j
@RequestMapping("/api")
public class ProductController {
  private final ProductQueryService productService;
  private final ProductResourceAssembler assembler;
  private final CommandGateway commandGateway;
  private static final String ENTITY_NAME = "ProductEntity";

  @Autowired
  public ProductController(ProductResourceAssembler assembler, CommandGateway commandGateway, ProductQueryService productService) {
    this.assembler = assembler;
    this.commandGateway = commandGateway;
    this.productService = productService;
  }

  @GetMapping(value = "/productEntities", produces = MediaTypes.HAL_JSON_VALUE)
  public List<ProductEntity> getAllProducts() {
    log.info("所有的工具记录");
    return productService.findAllProduct();
  }

  /*参见 EmployeeController.java
   * D:\yutao\源代码\spring-hateoas-examples\hypermedia\src\main\java\org\springframework\hateoas\examples\EmployeeController.java
   */
  //  @GetMapping(value = "/productEntities", produces = MediaTypes.HAL_JSON_VALUE)
//  public ResponseEntity findAll() {
//    return productService.findAll();
//    //    return ResponseEntity.ok(assembler.toResources(repository.findAll()));
//  }


  @GetMapping(value = "/productEntities/{id}", produces = MediaTypes.HAL_JSON_VALUE)
  public ResponseEntity<Resource<ProductEntity>> findOne(@PathVariable Long id) {
    log.info("查找一个记录");
    return productService.findOne(id).map(assembler::toResource).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  /*
   *spring官方案例 spring-hateoas-examples 中的
   *D:\yutao\源代码\spring-hateoas-examples\api-evolution\new-server\src\main\java\org\springframework\hateoas\examples\EmployeeController.java
   */
  //  @PostMapping("/products")
  //  public ResponseEntity<Resource<ProductEntity>> newProduct(@RequestBody ProductEntity product)
  // {
  //
  //    Optional<ProductEntity> savedProduct = Optional.of(repository.save(product));
  //    return savedProduct.map(id ->
  // ResponseEntity.created(linkTo(methodOn(ProductController.class).findOne(id)).toUri()).body(assembler.toResource(savedProduct))).orElse(ResponseEntity.notFound().build());
  ////    return savedProduct.getId().map(id ->
  // ResponseEntity.created(linkTo(methodOn(EmployeeController.class).findOne(id)).toUri()).body(assembler.toResource(savedProduct))).orElse(ResponseEntity.notFound().build());
  //  }

  @DeleteMapping("/productEntities/{id}")
  public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
    log.info("删除工具记录 : {}", id);
    //    countryService.delete(id);
    //    return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME,
    // id.toString())).build();
    return null;
  }


  /**
   * POST /countries : Create a new product.
   * 创建新记录
   *
   * @param product the country to create
   * @return the ResponseEntity with status 201 (Created) and with body the new country, or with
   * status 400 (Bad Request) if the country has already an ID
   * @throws URISyntaxException if the Location URI syntax is incorrect
   */

  @PostMapping("/productEntities")
  public ResponseEntity createProduct(@RequestBody ProductEntity product) {
    Optional<ProductName> name = createProductName(product.getName(), product.getGg(), product.getXh());
    ProductId id = ProductId.create();
    CreateProductCommand command = new CreateProductCommand(id, name.get());
    commandGateway.sendAndWait(command);
    return ResponseEntity.ok(assembler.toResource(productService.findByIdentifier(command.getProductId().getIdentifier()).get()));

  }

  private Optional<ProductName> createProductName(String name, String gg, String xh) {
    return Optional.of(ProductName.create(name, gg, xh));
  }

  /**
   * PUT  /countries : Updates an existing country.
   *
   * @param country the country to update
   * @return the ResponseEntity with status 200 (OK) and with body the updated country,
   * or with status 400 (Bad Request) if the country is not valid,
   * or with status 500 (Internal Server Error) if the country couldn't be updated
   * @throws URISyntaxException if the Location URI syntax is incorrect
   */

//  @PutMapping("/productEntities")
//  @Timed
//  public ResponseEntity<ProductEntity> updateProductEntity(@RequestBody ProductEntity product)  {
//    log.debug("REST request to update Country : {}", product);
//    ProductEntity result = productService.save(country);
//    return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, country.getId().toString())).body(result);
//  }

}
