package zy.cy6.zyxt.api.product;

import lombok.extern.slf4j.Slf4j;
import zy.cy6.zyxt.common.domain.AbstractAggregateIdentifier;

@Slf4j
//@EqualsAndHashCode

public final class ProductId extends AbstractAggregateIdentifier {

  private ProductId() {
    super();
    log.info("新建：ProductId");
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
