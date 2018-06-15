package zy.cy6.dqyt.zygl.product.command;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventhandling.EventHandler;

import lombok.Getter;
import zy.cy6.dqyt.zygl.api.company.CompanyCreatedEvent;
import zy.cy6.dqyt.zygl.api.product.ProductCreatedEvent;
import zy.cy6.dqyt.zygl.api.product.ProductId;
import zy.cy6.dqyt.zygl.api.product.ProductName;

@AggregateRoot
@Getter
public class Product {
	
    @AggregateIdentifier
    ProductId productId;
    
    public Product() {
    }

    public Product(ProductId productId, ProductName productName) {
        apply(ProductCreatedEvent.create(productId, productName));
    }
    
    @EventHandler
    public void handle(ProductCreatedEvent event) {
        this.productId = event.getProductId();
    }

}
