package zy.cy6.zyxt.api.product;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.google.common.base.Preconditions.checkNotNull;

@Getter
@Slf4j
public final class ProductCreateEvent {

    private  ProductId productId;
    private  ProductName productName;

     public ProductCreateEvent(ProductId productId, ProductName productName) {
      log.info("新建：ProductCreateEvent");

    this.productId = checkNotNull(productId, "没有工具标识符！");
    this.productName = checkNotNull(productName, "没有工具名称！");
    }

  public static ProductCreateEvent create(ProductId productId, ProductName productName) {
    return new ProductCreateEvent(productId, productName);
  }
}

