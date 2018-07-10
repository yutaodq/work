package zy.cy6.zyxt.query.product;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zy.cy6.zyxt.api.product.ProductCreatedEvent;
import zy.cy6.zyxt.api.product.ProductNameChangedEvent;
import zy.cy6.zyxt.query.product.repositories.ProductQueryRepository;

import java.util.Optional;


@Component
@Slf4j
public class ProductQueryListener {
  private ProductQueryRepository repository;

  @EventHandler
  public void handleProductCreatedEvent(ProductCreatedEvent event) {
    log.info("新建：productEntry实体");
    ProductEntity productEntry = new ProductEntity();
    productEntry.setIdentifier(event.getProductId().toString());
    productEntry.setName(event.getProductName().getName());
    productEntry.setSize(event.getProductName().getSize());
    productEntry.setModel(event.getProductName().getModel());
    repository.save(productEntry);
  }

  @EventHandler
  public void changeProductName(ProductNameChangedEvent event) {
    log.info("修改：productEntry实体的名称、规格、型号");
    Optional<ProductEntity> productEntry = repository.findByIdentifier(event.getProductId().toString());
    ProductEntity entity = productEntry.get();
    entity.setName(event.getProductName().getName());
    entity.setSize(event.getProductName().getSize());
    entity.setModel(event.getProductName().getModel());
    repository.save(entity);
  }

  @Autowired
  public void setRepository(ProductQueryRepository repository) {
    this.repository = repository;
  }
}
