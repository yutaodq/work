package zy.cy6.zyxt.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import zy.cy6.zyxt.query.product.ProductEntity;
import zy.cy6.zyxt.query.product.repositories.ProductQueryRepository;
import zy.cy6.zyxt.web.product.ProductResourceAssembler;

@RestController
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductQueryRepository repository;
    private final ProductResourceAssembler assembler;

    @Autowired
    public ProductController(ProductQueryRepository repository, ProductResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping(value = "/products", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Resources<Resource<ProductEntity>>> findAll() {
        return ResponseEntity.ok(assembler.toResources(repository.findAll()));
    }

    @GetMapping(value = "/products/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Resource<ProductEntity>> findOne(@PathVariable Long id) {
        return repository.findById(id).map(assembler::toResource).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
