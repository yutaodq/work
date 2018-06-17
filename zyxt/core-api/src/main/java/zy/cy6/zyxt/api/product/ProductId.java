package zy.cy6.zyxt.api.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zy.cy6.zyxt.common.domain.AbstractIdentifier;

public final class ProductId extends AbstractIdentifier {
  private Logger log = LoggerFactory.getLogger(ProductId.class);

  private ProductId() {
    super();
    log.info("新建：OrderId");
  }

  private ProductId(String identifier) {
    super(identifier);
    log.info("新建：ProductId");
  }

  public static ProductId create() {
    return new ProductId();
  }

  public static ProductId create(String identifier) {
    return new ProductId(identifier);
  }

  @Override
  public String toString() {
    return "ProductId{" + "identifier='" + identifier() + '\'' + '}';
  }
}
