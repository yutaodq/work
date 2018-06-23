package zy.cy6.zyxt.query.product;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zy.cy6.zyxt.api.product.ProductCreateEvent;
import zy.cy6.zyxt.query.product.repositories.ProductQueryRepository;


@Component
public class ProductListener {
    private ProductQueryRepository productRepository;

    @EventHandler
    public void handleCompanyCreatedEvent(ProductCreateEvent event) {
//        ProductEntry productEntry = new productEntry();
//        productEntry.setIdentifier(event.getCompanyIdentifier().toString());
//        productEntry.setValue(event.getCompanyValue());
//        productEntry.setAmountOfShares(event.getAmountOfShares());
//        productEntry.setTradeStarted(true);
//        productEntry.setName(event.getCompanyName());

//        productRepository.save(productEntry);
    }

    @Autowired
    public void setProductRepository(ProductQueryRepository productRepository) {
        this.productRepository = productRepository;
    }}
