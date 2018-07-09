package zy.cy6.zyxt.api.product;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class CreateProductCommand {
  @NotNull(message = "工具标识对象不能为空")
  private ProductId productId;

  @NotNull(message = "工具名称对象不能为空")
  private ProductName productName;

//  @Override
//  public String toString() {
////    return "dasf";
//    return MoreObjects.toStringHelper(this).add("新建工具标识：", productId.toString()).add("新建工具名称", productName.getName()).add("新建工具规格：", productName.getSize()).add("新建工具型号：", productName.getModel()).toString();
//  }
}
