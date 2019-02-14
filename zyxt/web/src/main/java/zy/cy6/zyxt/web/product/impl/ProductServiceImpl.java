/*
 *参见 spring官方案例 spring-hateoas-examples
 */
package zy.cy6.zyxt.web.product.impl;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zy.cy6.zyxt.api.product.product.CreateProductCommand;
import zy.cy6.zyxt.api.product.product.ProductId;
import zy.cy6.zyxt.api.product.product.ProductName;
import zy.cy6.zyxt.query.product.ProductEntity;
import zy.cy6.zyxt.query.product.repositories.ProductQueryRepository;
import zy.cy6.zyxt.web.product.ProductResourceAssembler;
import zy.cy6.zyxt.web.product.ProductService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
  private final ProductQueryRepository repository;
  private final ProductResourceAssembler assembler;
  private CommandBus commandBus;
  private final CommandGateway commandGateway;

  @Autowired
  public ProductServiceImpl(CommandGateway commandGateway, CommandBus commandBus, ProductQueryRepository repository, ProductResourceAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
    this.commandBus = commandBus;
    this.commandGateway = commandGateway;
  }

  public Optional<ProductEntity> findProductName(String name, String gg, String xh) {
    return repository.findByNameAndGgAndXh(name, gg, xh);
  }

  public List<ProductEntity> findAllProduct() {
    log.info("所有的工具记录");
    return repository.findAll();
  }

  /*参见 EmployeeController.java
   * D:\yutao\源代码\spring-hateoas-examples\hypermedia\src\main\java\org\springframework\hateoas\examples\EmployeeController.java
   */
  //  @GetMapping(value = "/products", produces = MediaTypes.HAL_JSON_VALUE)
  public ResponseEntity<Resources<Resource<ProductEntity>>> findAll() {
    return ResponseEntity.ok(assembler.toResources(repository.findAll()));
  }

  public ResponseEntity<Resource<ProductEntity>> findOne(Long id) {
    return repository.findById(id).map(assembler::toResource).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  public ResponseEntity<Resource<ProductEntity>> create(ProductEntity product) throws Exception {
    ProductName name = ProductName.create(product.getName(), product.getGg(), product.getXh());
    log.info("ProductName name = ProductName.create(product.getName(), product.getGg(), product.getXh());");
    ProductId id = ProductId.create();
    CreateProductCommand command = new CreateProductCommand(id, name);
    commandGateway.send(command);
    Optional<ProductEntity> productSave = repository.findByIdentifier(id.getIdentifier());

    return ResponseEntity.ok(assembler.toResource(productSave.get()));
//    } catch (Exception e) {
//      log.info(" System.exit(1); System.exit(1); System.exit(1);");
//      return ResponseEntity.badRequest();
//    }
//    commandGateway.send(command, new CommandCallback<CreateProductCommand, Object>() {
//      @Override
//      public void onSuccess(CommandMessage<? extends CreateProductCommand> commandMessage, Object o) {
//        return;
//      }
//      @Override
//      public void onFailure(CommandMessage<? extends CreateProductCommand> commandMessage, Throwable throwable) {
//        return;
//      }
//    });

  }

}
