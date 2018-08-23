package zy.cy6.zyxt.product.config;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.spring.config.AxonConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zy.cy6.zyxt.product.command.Product;
import zy.cy6.zyxt.product.command.ProductCommandHandler;
import zy.cy6.zyxt.query.product.ProductQueryService;

@Configuration
public class ProductConfig {
  @Autowired
  private AxonConfiguration axonConfiguration;
  @Autowired
  private EventBus eventBus;
  @Autowired
  private ProductQueryService productQueryService;
  @Bean
  public ProductCommandHandler productCommandHandler() {
    return new ProductCommandHandler(axonConfiguration.repository(Product.class), eventBus, productQueryService);
  }

  //  @Autowired
//  private AxonConfiguration axonConfiguration;
//  @Autowired
//  private EventBus eventBus;


//    @Autowired
//    private EventStore eventStore;
//
//  @Autowired
//  private Snapshotter snapshotter;
//
//  @Autowired
//  private Cache cache;

//  @Autowired
//  private ProductListenerYu productListenerYu;

//  @Bean
//  @Scope("prototype")
//  public Product product() {
//    return new Product();
//  }

//  @Bean
//  public Repository<Product> productRepository() {
//    EventCountSnapshotTriggerDefinition snapshotTriggerDefinition = new EventCountSnapshotTriggerDefinition(snapshotter, 50);
//
//    CachingEventSourcingRepository<Product> repository = new CachingEventSourcingRepository<Product>(productAggregateFactory(), eventStore, cache, snapshotTriggerDefinition);
//
//    return repository;
//  }
//
//  @Bean
//  public AggregateFactory<Product> productAggregateFactory() {
//    SpringPrototypeAggregateFactory<Product> springPrototypeAggregateFactory = new SpringPrototypeAggregateFactory<>();
//    springPrototypeAggregateFactory.setPrototypeBeanName("product");
//    return springPrototypeAggregateFactory;
//  }

//  @Bean
//  public ProductCommandHandler productCommandHandler() {
//    return new ProductCommandHandler(productRepository(), eventStore);
//  }

//  @Bean
//  public ProductCommandHandler productCommandHandler() {
//    return new ProductCommandHandler(axonConfiguration.repository(Product.class), eventBus);
//  }

//  @Bean
//  public EventProcessor productsEventProcessor() {
//    SubscribingEventProcessor eventProcessor = new SubscribingEventProcessor("productEventProcessor", new SimpleEventHandlerInvoker(productListenerYu), eventStore);
//    eventProcessor.start();
//
//    return eventProcessor;
//  }

}
