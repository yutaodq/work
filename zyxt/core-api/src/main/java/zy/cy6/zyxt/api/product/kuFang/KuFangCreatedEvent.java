package zy.cy6.zyxt.api.product.kuFang;

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

    public KufangCreatedEvent(KufangId kuFangId, KufangName kuFangName) {
        log.info("新建：KufangCreatedEvent");

        this.kuFangId = checkNotNull(kuFangId, "没有库房标识符！");
        this.kuFangName = checkNotNull(kuFangName, "没有库房名称！");
    }

    public static KufangCreatedEvent create(KufangId kuFangId, KufangName kuFangName) {
        return new KufangCreatedEvent(kuFangId, kuFangName);
    }
}

