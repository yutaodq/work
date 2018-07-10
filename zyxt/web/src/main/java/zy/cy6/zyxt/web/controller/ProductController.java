/*
 *参见 spring官方案例 spring-hateoas-examples
 */
package zy.cy6.zyxt.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import zy.cy6.zyxt.api.product.ChangeProductNameCommand;
import zy.cy6.zyxt.api.product.CreateProductCommand;
import zy.cy6.zyxt.api.product.ProductId;
import zy.cy6.zyxt.api.product.ProductName;
import zy.cy6.zyxt.query.product.ProductEntity;
import zy.cy6.zyxt.query.product.repositories.ProductQueryRepository;
import zy.cy6.zyxt.web.product.ProductResourceAssembler;

import java.util.Optional;

import static org.axonframework.commandhandling.GenericCommandMessage.asCommandMessage;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@Slf4j
public class ProductController {
  private final ProductQueryRepository repository;
  private final ProductResourceAssembler assembler;

  private CommandBus commandBus;

  @Autowired
  public ProductController(CommandBus commandBus, ProductQueryRepository repository, ProductResourceAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
    this.commandBus = commandBus;
  }

  /*参见 EmployeeController.java
   * D:\yutao\源代码\spring-hateoas-examples\hypermedia\src\main\java\org\springframework\hateoas\examples\EmployeeController.java
   */
  @GetMapping(value = "/products", produces = MediaTypes.HAL_JSON_VALUE)
  public ResponseEntity<Resources<Resource<ProductEntity>>> findAll() {
    ProductName name = ProductName.create("yutao", "123", "miao");
    ProductId id = ProductId.create();
    CreateProductCommand command = new CreateProductCommand(id, name);

    Optional<CreateProductCommand> commandOptional = Optional.of(command);
    commandBus.dispatch(asCommandMessage(command));
    return ResponseEntity.ok(assembler.toResources(repository.findAll()));
  }

  @GetMapping(value = "/products/{id}", produces = MediaTypes.HAL_JSON_VALUE)
  public ResponseEntity<Resource<ProductEntity>> findOne(@PathVariable Long id) {
    ProductEntity entity = repository.findById(id).get();
    ProductName name = ProductName.create("yu", "tao", "ddddddddd");
    ProductId productId = ProductId.create(entity.getIdentifier());
    ChangeProductNameCommand command = new ChangeProductNameCommand(productId, name);
    commandBus.dispatch(asCommandMessage(command));

    return repository.findById(id).map(assembler::toResource).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  /*
   *spring官方案例 spring-hateoas-examples 中的
   *D:\yutao\源代码\spring-hateoas-examples\api-evolution\new-server\src\main\java\org\springframework\hateoas\examples\EmployeeController.java
   */
//  @PostMapping("/products")
//  public ResponseEntity<Resource<ProductEntity>> newProduct(@RequestBody ProductEntity product) {
//
//    Optional<ProductEntity> savedProduct = Optional.of(repository.save(product));
//    return savedProduct.map(id -> ResponseEntity.created(linkTo(methodOn(ProductController.class).findOne(id)).toUri()).body(assembler.toResource(savedProduct))).orElse(ResponseEntity.notFound().build());
////    return savedProduct.getId().map(id -> ResponseEntity.created(linkTo(methodOn(EmployeeController.class).findOne(id)).toUri()).body(assembler.toResource(savedProduct))).orElse(ResponseEntity.notFound().build());
//  }
}
