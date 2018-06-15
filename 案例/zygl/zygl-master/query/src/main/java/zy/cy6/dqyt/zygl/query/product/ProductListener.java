package zy.cy6.dqyt.zygl.query.product;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zy.cy6.dqyt.zygl.api.product.ProductCreatedEvent;
import zy.cy6.dqyt.zygl.query.product.repositories.ProductQueryRepository;

@Component
public class ProductListener {

    private ProductQueryRepository productRepository;

    @EventHandler
    public void handleProductCreatedEvent(ProductCreatedEvent event) {
    	ProductEntry productEntry = new ProductEntry.Builder()
    			.identifier(event.getProductId().identifier().toString())
    			.name(event.getProductName().getName())
    			.model(event.getProductName().getModel())
    			.size(event.getProductName().getSize())
    			.unit(event.getProductName().getUnit())
    			.build();

        productRepository.save(productEntry);
    }

    @Autowired
    public void setCompanyRepository(ProductQueryRepository productRepository) {
        this.productRepository = productRepository;
    }
}
