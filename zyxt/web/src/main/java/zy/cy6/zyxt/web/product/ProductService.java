package zy.cy6.zyxt.web.product;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import zy.cy6.zyxt.query.product.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
  List<ProductEntity> findAllProduct();

  ResponseEntity<Resources<Resource<ProductEntity>>> findAll();

  ResponseEntity<Resource<ProductEntity>> findOne(Long id);

  Optional<ProductEntity> findProductName(String name, String gg, String xh);

  ResponseEntity<Resource<ProductEntity>> create(ProductEntity product) throws Exception;
}
