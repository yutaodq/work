package zy.cy6.zyxt.api.product;

import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
public class ProductNameChangedEvent {
  @TargetAggregateIdentifier
  private ProductId productId;
  private ProductName productName;
  
}
