package zy.cy6.zyxt.api.product.kufang;

import lombok.Builder;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
@Builder
@Value
public final class KufangCreatedEvent {
  @TargetAggregateIdentifier
  private KufangId kufangId;
  private KufangName kufangName;
  private String bz;

  public KufangCreatedEvent(KufangId kufangId, KufangName kufangName, String bz) {
    log.info("新建：KufangCreatedEvent");
    this.kufangId = checkNotNull(kufangId, "新建库房记录时，没有库房标识符！");
    this.kufangName = checkNotNull(kufangName, "新建库房记录时，没有库房名称！");
    this.bz = bz;
  }

}

