package zy.cy6.zyxt.product.command;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import zy.cy6.zyxt.api.product.*;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/*
事件溯源聚合的聚合根还必须包含一个无参的构造函数，用@NoArgsConstructor这个构造函数。
，Axon Framework使用这个构造函数创建一个空的聚合实例，
在使用过去的事件之前初始化它。没有提供这种构造函数加载聚合时将导致异常
 */
@Aggregate
@Slf4j
@NoArgsConstructor
public class Product {
    @AggregateIdentifier
    private ProductId productId;
    private ProductName productName;

    @CommandHandler
    public Product(CreateProductCommand command) {
        log.info("新建：Product");
        apply(ProductCreatedEvent.create(command.getProductId(), command.getProductName()));
    }

    @SuppressWarnings("UnusedDeclaration")
    @EventSourcingHandler
    public void handle(ProductCreatedEvent event) {
        log.info("在聚合Product中处理ProductCreatedEvent 事件");
        this.productId = event.getProductId();
        this.productName = event.getProductName();
    }

    public void changeProductName(ProductName productName) {
        log.info("改工具名称，并发布修改工具名称事件");
        apply(new ProductNameChangedEvent(productId, productName));
    }

    @SuppressWarnings("UnusedDeclaration")
    @EventSourcingHandler
    public void on(ProductNameChangedEvent event) {
        this.productName = event.getProductName();
    }


}
