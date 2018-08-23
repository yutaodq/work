package zy.cy6.zyxt.query.product;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zy.cy6.zyxt.api.exception.DomainException;
import zy.cy6.zyxt.api.product.ProductCreatedEvent;
import zy.cy6.zyxt.api.product.ProductNameChangedEvent;
import zy.cy6.zyxt.query.product.repositories.ProductQueryRepository;

import java.util.Optional;


@Component
@Slf4j
public class ProductQueryListener {
  private ProductQueryRepository repository;

  @EventHandler
//  public void handleProductCreatedEvent(ProductCreatedEvent event) throws ProductNameNotUniqueException {

  public void handleProductCreatedEvent(ProductCreatedEvent event) throws DomainException {
//    findProductName().ifPresent(p -> {
//      throw new DomainException(ErrorCode.VIOLATION_CONSTRAINT, "com.believe.bike.error.user.NotFound", "aaa");
//    });
    create(event);

  }


  private void create(ProductCreatedEvent event) {
    ProductEntity productEntry = new ProductEntity();
    productEntry.setIdentifier(event.getProductId().getIdentifier());
    productEntry.setName(event.getProductName().getName());
    productEntry.setXh(event.getProductName().getXh());
    productEntry.setGg(event.getProductName().getGg());
    repository.save(productEntry);
  }
  @EventHandler
  public void changeProductName(ProductNameChangedEvent event) {
    log.info("修改：productEntry实体的名称、规格、型号");
    Optional<ProductEntity> productEntry = repository.findByIdentifier(event.getProductId().getIdentifier());
    ProductEntity entity = productEntry.get();
    entity.setName(event.getProductName().getName());
    entity.setXh(event.getProductName().getXh());
    entity.setGg(event.getProductName().getGg());

    repository.save(entity);
  }

  @Autowired
  public void setRepository(ProductQueryRepository repository) {
    this.repository = repository;
  }
}
