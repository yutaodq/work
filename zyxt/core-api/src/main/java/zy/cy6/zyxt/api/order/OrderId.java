package zy.cy6.zyxt.api.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zy.cy6.zyxt.common.domain.AbstractIdentifier;

import static org.axonframework.common.IdentifierFactory.getInstance;

public class OrderId extends AbstractIdentifier {
  private Logger log = LoggerFactory.getLogger(OrderId.class);

  public OrderId(String identifier) {
    super(identifier);
    log.info("新建：OrderId");
  }

  public static OrderId create() {
    return create(getInstance().generateIdentifier());
  }

  public static OrderId create(String identifier) {
    return new OrderId(identifier);
  }

  @Override
  public String toString() {
    return "OrderId{" + "identifier='" + identifier() + '\'' + '}';
  }

}
