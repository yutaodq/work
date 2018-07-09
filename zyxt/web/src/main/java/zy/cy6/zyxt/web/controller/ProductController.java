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
import zy.cy6.zyxt.api.product.CreateProductCommand;
import zy.cy6.zyxt.api.product.ProductId;
import zy.cy6.zyxt.api.product.ProductName;
import zy.cy6.zyxt.query.product.ProductEntity;
import zy.cy6.zyxt.query.product.repositories.ProductQueryRepository;
import zy.cy6.zyxt.web.product.ProductResourceAssembler;

import java.util.Optional;

import static org.axonframework.commandhandling.GenericCommandMessage.asCommandMessage;

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
        return repository.findById(id).map(assembler::toResource).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
