package zy.cy6.zyxt.product.command;

import org.axonframework.commandhandling.model.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import zy.cy6.zyxt.api.product.ProductId;

public class ProductCommandHandler {
    private final static Logger log = LoggerFactory.getLogger(ProductId.class);

    private Repository<Product> repository;

    @Autowired
    @Qualifier("productRepository")
    public void setRepository(Repository<Product> productRepository) {
        this.repository = productRepository;
    }

}
