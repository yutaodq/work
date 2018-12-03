package zy.cy6.zyxt.api.product;

import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

@Value
public class ChangeProductNameCommand {
  @TargetAggregateIdentifier
  private ProductId productId;
  @NotNull(message = "工具名称对象不能为空")
  private ProductName productName;
}
