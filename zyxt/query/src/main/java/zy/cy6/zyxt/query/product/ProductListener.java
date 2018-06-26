package zy.cy6.zyxt.query.product;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zy.cy6.zyxt.api.product.ProductCreateEvent;
import zy.cy6.zyxt.query.product.repositories.ProductQueryRepository;


@Component
public class ProductListener {
    private ProductQueryRepository productRepository;

    @EventHandler
    public void handleProductCreatedEvent(ProductCreateEvent event) {
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
    }}
