package zy.cy6.zyxt.api.product.kufang;

import lombok.extern.slf4j.Slf4j;

import zy.cy6.zyxt.common.domain.AbstractAggregateIdentifier;
import zy.cy6.zyxt.common.domain.AbstractAggregateIdentifierBuilder;


@Slf4j
public final class KufangId extends AbstractAggregateIdentifier {

  private KufangId(String identifier) {
    super(identifier);
    log.info("新建库房标识：KufangId");
  }

  public static KufangIdBuilder builder() {
    return new KufangIdBuilder();
  }

  @Override
  public String toString() {
    return "库房标识:" + super.toString();
  }

  /*
   * 静态类
   */
  public static class KufangIdBuilder extends AbstractAggregateIdentifierBuilder {
    public KufangIdBuilder identifier(String identifier) {
      setIdentifier(identifier);
      return this;
    }

    public KufangId build() {
      return new KufangId(getIdentifier());
    }
  }
}
