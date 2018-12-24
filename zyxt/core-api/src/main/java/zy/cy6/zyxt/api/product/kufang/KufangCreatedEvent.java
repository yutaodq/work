package zy.cy6.zyxt.api.product.kufang;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import static com.google.common.base.Preconditions.checkNotNull;

@Getter
@Slf4j
public final class KufangCreatedEvent {

  @TargetAggregateIdentifier
  private KufangId kuFangId;
  private KufangName kuFangName;
  private String bz;

  public KufangCreatedEvent(KufangId kuFangId, KufangName kuFangName, String bz) {
    log.info("新建：KufangCreatedEvent");

    this.kuFangId = checkNotNull(kuFangId, "没有库房标识符！");
    this.kuFangName = checkNotNull(kuFangName, "没有库房名称！");
    this.bz = bz;
  }

  public static KufangCreatedEvent create(KufangId kuFangId, KufangName kuFangName, String bz) {
    return new KufangCreatedEvent(kuFangId, kuFangName, bz);
  }
}

