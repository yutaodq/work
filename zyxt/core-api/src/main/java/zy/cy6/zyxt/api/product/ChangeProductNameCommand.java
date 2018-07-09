package zy.cy6.zyxt.api.product;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class ChangeProductNameCommand {
  @NotNull(message = "工具名称对象不能为空")
  private ProductName productName;
}
