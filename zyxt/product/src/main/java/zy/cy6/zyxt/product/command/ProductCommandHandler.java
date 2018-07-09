package zy.cy6.zyxt.product.command;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventhandling.EventBus;
import zy.cy6.zyxt.api.product.CreateProductCommand;

@Slf4j

public class ProductCommandHandler {

    private Repository<Product> repository;
    private EventBus eventBus;


    public ProductCommandHandler(Repository<Product> repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    @CommandHandler
    public void handleCreateProduct(CreateProductCommand command) throws Exception {
        log.info("CreateProductCommand 命令处理器，在handleCreateProduct中执行的");
        repository.newInstance(() -> {
            return new Product(command);
        });
    }

}
