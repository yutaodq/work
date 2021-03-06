package zy.cy6.zyxt.api.product.product;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import static com.google.common.base.Preconditions.checkNotNull;

@Getter
@Slf4j
public final class ProductCreatedEvent {

  @TargetAggregateIdentifier
  private ProductId productId;
    private  ProductName productName;

  public ProductCreatedEvent(ProductId productId, ProductName productName) {
    log.info("新建：ProductCreatedEvent");
    this.productId = checkNotNull(productId, "没有工具标识符！");
    this.productName = checkNotNull(productName, "没有工具名称！");
    }

  public static ProductCreatedEvent create(ProductId productId, ProductName productName) {
    return new ProductCreatedEvent(productId, productName);
  }
}

