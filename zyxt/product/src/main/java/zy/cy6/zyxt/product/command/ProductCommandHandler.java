package zy.cy6.zyxt.product.command;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.AggregateNotFoundException;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventhandling.EventBus;
import zy.cy6.zyxt.api.exception.DomainException;
import zy.cy6.zyxt.api.exception.ErrorCode;
import zy.cy6.zyxt.api.product.ChangeProductNameCommand;
import zy.cy6.zyxt.api.product.CreateProductCommand;
import zy.cy6.zyxt.api.product.ProductId;
import zy.cy6.zyxt.query.product.ProductQueryService;

@Slf4j
public class ProductCommandHandler {

    private Repository<Product> repository;
    private EventBus eventBus;
    private ProductQueryService productQueryService;

    public ProductCommandHandler(Repository<Product> repository, EventBus eventBus, ProductQueryService productQueryService) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.productQueryService = productQueryService;
    }

    @CommandHandler
    public void handleChangeProductName(ChangeProductNameCommand command) throws Exception {
        log.info("ChangeProductNameCommand 命令处理器，在handleChangeProductName中执行的");
        try {
            Aggregate<Product> productAggregate = repository.load(command.getProductId().getIdentifier());
            productAggregate.execute(product -> product.changeProductName(command.getProductName()));
        } catch (AggregateNotFoundException exception) {
            //        eventBus.publish(asEventMessage(new
            // SourceBankAccountNotFoundEvent(command.getBankTransferId())));

        }
    }

    @CommandHandler
    public ProductId handleCreateProduct(CreateProductCommand command) throws Exception {
        productQueryService.findByProductName(command.getProductName()).ifPresent(p -> {
            throw new DomainException(ErrorCode.VIOLATION_CONSTRAINT, "com.believe.bike.error.user.NotFound", "aaa");
        });

        ProductId identifier = command.getProductId();
        repository.newInstance(() -> new Product(command));
        return identifier;
    }

}
