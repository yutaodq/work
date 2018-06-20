package zy.cy6.zyxt.product.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.spring.stereotype.Aggregate;
import zy.cy6.zyxt.api.product.CreateProductCommand;
import zy.cy6.zyxt.api.product.ProductCreateEvent;
import zy.cy6.zyxt.api.product.ProductId;
import zy.cy6.zyxt.api.product.ProductName;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Product {
    @AggregateIdentifier
    private ProductId productId;
    private ProductName productName;
    public Product() {
    }
    @CommandHandler
    public Product(CreateProductCommand command) {
        apply(ProductCreateEvent.create(command.getProductId(), command.getProductName()));

    }

    @EventHandler
    public void handle(ProductCreateEvent event) {
        this.productId = event.getProductId();
    }

}
