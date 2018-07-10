package zy.cy6.zyxt.product.command;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.AggregateNotFoundException;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventhandling.EventBus;
import zy.cy6.zyxt.api.product.ChangeProductNameCommand;

@Slf4j

public class ProductCommandHandler {

    private Repository<Product> repository;
    private EventBus eventBus;


    public ProductCommandHandler(Repository<Product> repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    @CommandHandler
    public void handleChangeProductName(ChangeProductNameCommand command) throws Exception {
        log.info("ChangeProductNameCommand 命令处理器，在handleChangeProductName中执行的");
        try {
            Aggregate<Product> productAggregate = repository.load(command.getProductId().identifier());
            productAggregate.execute(product -> product.changeProductName(command.getProductName()));
            log.info("aaaaaaaaaaaaaaa:" + command.getProductId().identifier());
        } catch (AggregateNotFoundException exception) {
            log.info("bbbbbbbbbbbbbbbbbbbbbbbb:" + command.getProductId().toString());

            //        eventBus.publish(asEventMessage(new
            // SourceBankAccountNotFoundEvent(command.getBankTransferId())));

        }
    }
}
