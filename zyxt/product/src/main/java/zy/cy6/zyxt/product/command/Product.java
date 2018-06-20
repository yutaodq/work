package zy.cy6.zyxt.product.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zy.cy6.zyxt.api.product.CreateProductCommand;
import zy.cy6.zyxt.api.product.ProductCreateEvent;
import zy.cy6.zyxt.api.product.ProductId;
import zy.cy6.zyxt.api.product.ProductName;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Product {
    private final static Logger log = LoggerFactory.getLogger(Product.class);
    @AggregateIdentifier
    private ProductId productId;
    private ProductName productName;
    @SuppressWarnings("UnusedDeclaration")
    public Product() {
    }
    @CommandHandler
    public Product(CreateProductCommand command) {
        log.info("新建：Product");
        apply(ProductCreateEvent.create(command.getProductId(), command.getProductName()));
    }

    @EventHandler
    public void handle(ProductCreateEvent event) {
        this.productId = event.getProductId();
        this.productName = event.getProductName();
    }

}
