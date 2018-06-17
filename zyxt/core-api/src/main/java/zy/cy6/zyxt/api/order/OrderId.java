package zy.cy6.zyxt.api.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zy.cy6.zyxt.common.domain.AbstractIdentifier;

public final class OrderId extends AbstractIdentifier {
  private Logger log = LoggerFactory.getLogger(OrderId.class);

  private OrderId() {
    super();
    log.info("新建：OrderId");
  }

  private OrderId(String identifier) {
    super(identifier);
    log.info("新建：OrderId");
  }

  public static OrderId create() {
    return new OrderId();
  }

  public static OrderId create(String identifier) {
    return new OrderId(identifier);
  }

  @Override
  public String toString() {
    return "OrderId{" + "identifier='" + identifier() + '\'' + '}';
  }
}
