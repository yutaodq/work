package zy.cy6.zyxt.query.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zy.cy6.zyxt.api.product.ProductName;
import zy.cy6.zyxt.query.product.repositories.ProductQueryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductQueryService {
  private final ProductQueryRepository productRepository;

  @Autowired
  public ProductQueryService(ProductQueryRepository productRepository) {
    this.productRepository = productRepository;

  }

  public Optional<ProductEntity> findOne(Long id) {
    return productRepository.findById(id);
  }

  public Optional<ProductEntity> findByProductName(ProductName productName) {
    String name = productName.getName();
    String gg = productName.getGg();
    String xh = productName.getXh();
    return productRepository.findByNameAndGgAndXh(name, gg, xh);
  }

  public Optional<ProductEntity> findByIdentifier(String identifier) {
    return productRepository.findByIdentifier(identifier);

  }

  public List<ProductEntity> findAllProduct() {
    log.info("所有的工具记录");
    return productRepository.findAll();
  }

}
