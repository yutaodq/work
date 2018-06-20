package zy.cy6.zyxt.product.command;

import org.axonframework.commandhandling.CommandBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zy.cy6.zyxt.api.product.ProductId;

@Component
public class ProductListener {
    private final static Logger log = LoggerFactory.getLogger(ProductId.class);
    private CommandBus commandBus;

    @Autowired
    public void setCommandBus(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

}
