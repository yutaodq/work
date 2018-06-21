package zy.cy6.zyxt.product.config;

import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventhandling.EventProcessor;
import org.axonframework.eventhandling.SimpleEventHandlerInvoker;
import org.axonframework.eventhandling.SubscribingEventProcessor;
import org.axonframework.eventsourcing.AggregateFactory;
import org.axonframework.eventsourcing.CachingEventSourcingRepository;
import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition;
import org.axonframework.eventsourcing.Snapshotter;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.spring.eventsourcing.SpringPrototypeAggregateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import zy.cy6.zyxt.product.command.Product;
import zy.cy6.zyxt.product.command.ProductCommandHandler;
import zy.cy6.zyxt.product.command.ProductListener;

@Configuration
public class ProductConfig {
  @Autowired
  private EventStore eventStore;

  @Autowired
  private Snapshotter snapshotter;

  @Autowired
  private Cache cache;

  @Autowired
  private ProductListener productListener;

  @Bean
  @Scope("prototype")
  public Product product() {
    return new Product();
  }

  @Bean
  public Repository<Product> productRepository() {
    EventCountSnapshotTriggerDefinition snapshotTriggerDefinition = new EventCountSnapshotTriggerDefinition(snapshotter, 50);

    CachingEventSourcingRepository<Product> repository = new CachingEventSourcingRepository<>(productAggregateFactory(), eventStore, cache, snapshotTriggerDefinition);

    return repository;
  }

  @Bean
  public AggregateFactory<Product> productAggregateFactory() {
    SpringPrototypeAggregateFactory<Product> springPrototypeAggregateFactory = new SpringPrototypeAggregateFactory<>();
    springPrototypeAggregateFactory.setPrototypeBeanName("product");

    return springPrototypeAggregateFactory;
  }

  @Bean
  public ProductCommandHandler productCommandHandler() {
    return new ProductCommandHandler(productRepository());
  }

  @Bean
  public EventProcessor productsEventProcessor() {
    SubscribingEventProcessor eventProcessor = new SubscribingEventProcessor("productEventProcessor", new SimpleEventHandlerInvoker(productListener), eventStore);
    eventProcessor.start();

    return eventProcessor;
  }

}
