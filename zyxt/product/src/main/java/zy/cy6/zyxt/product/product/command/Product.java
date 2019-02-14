package zy.cy6.zyxt.product.product.command;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import zy.cy6.zyxt.api.product.product.*;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/*
事件溯源聚合的聚合根还必须包含一个无参的构造函数，用@NoArgsConstructor这个构造函数。
，Axon Framework使用这个构造函数创建一个空的聚合实例，
在使用过去的事件之前初始化它。没有提供这种构造函数加载聚合时将导致异常
 */
@Aggregate
@Slf4j
public class Product {
    @AggregateIdentifier
    private ProductId productId;
    private ProductName productName;

    @SuppressWarnings("UnusedDeclaration")
    public Product() {
        //Axon Framework 要求聚合根必需有无参数的构造函数
    }

    @CommandHandler
    public Product(CreateProductCommand command) {
        apply(ProductCreatedEvent.create(command.getProductId(), command.getProductName()));
    }

    @SuppressWarnings("UnusedDeclaration")
    @EventSourcingHandler
    public void handle(ProductCreatedEvent event) {
        this.productId = event.getProductId();
        this.productName = event.getProductName();
    }

    public void changeProductName(ProductName productName) {
        apply(new ProductNameChangedEvent(productId, productName));
    }

    @SuppressWarnings("UnusedDeclaration")
    @EventSourcingHandler
    public void on(ProductNameChangedEvent event) {
        this.productName = event.getProductName();
    }
}
