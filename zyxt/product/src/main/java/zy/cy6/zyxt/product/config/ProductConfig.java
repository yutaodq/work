package zy.cy6.zyxt.product.config;

import lombok.NoArgsConstructor;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.spring.config.AxonConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zy.cy6.zyxt.product.command.Kufang;
import zy.cy6.zyxt.product.command.KufangCommandHandler;
import zy.cy6.zyxt.product.command.Product;
import zy.cy6.zyxt.product.command.ProductCommandHandler;
import zy.cy6.zyxt.query.product.KufangQueryService;
import zy.cy6.zyxt.query.product.ProductQueryService;

@Configuration
@NoArgsConstructor
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

  @Autowired
  private KufangQueryService kufangQueryService;
  @Bean
  public KufangCommandHandler kufangcommandhandler() {
    return new KufangCommandHandler(axonConfiguration.repository(Kufang.class), eventBus, kufangQueryService);
  }
}
