package zy.cy6.zyxt.api.product;

import lombok.Getter;

import static com.google.common.base.Preconditions.checkNotNull;

@Getter
public final class ProductCreateEvent {
  private final ProductId productId;
  private final ProductName productName;

  private ProductCreateEvent(ProductId productId, ProductName productName) {
    this.productId = checkNotNull(productId, "没有工具标识符！");
    this.productName = checkNotNull(productName, "没有工具名称！");
  }

  public static ProductCreateEvent create(ProductId productId, ProductName productName) {
    return new ProductCreateEvent(productId, productName);
  }
}

