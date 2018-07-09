package zy.cy6.zyxt.query.product;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zy.cy6.zyxt.api.product.ProductCreatedEvent;
import zy.cy6.zyxt.query.product.repositories.ProductQueryRepository;


@Component
@Slf4j
public class ProductQueryListener {
  private ProductQueryRepository productRepository;

  @EventHandler
  public void handleProductCreatedEvent(ProductCreatedEvent event) {
    log.info("新建：productEntry实体");
    ProductEntity productEntry = new ProductEntity();
    productEntry.setIdentifier(event.getProductId().toString());
    productEntry.setName(event.getProductName().getName());
    productEntry.setSize(event.getProductName().getSize());
    productEntry.setModel(event.getProductName().getModel());
    productRepository.save(productEntry);
  }

  @Autowired
  public void setProductRepository(ProductQueryRepository productRepository) {
    this.productRepository = productRepository;
  }
}
