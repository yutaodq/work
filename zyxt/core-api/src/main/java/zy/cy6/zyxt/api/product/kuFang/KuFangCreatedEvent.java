package zy.cy6.zyxt.api.product.kuFang;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import static com.google.common.base.Preconditions.checkNotNull;

@Getter
@Slf4j
public final class KuFangCreatedEvent {

    @TargetAggregateIdentifier
    private KuFangId kuFangId;
    private  KuFangName kuFangName;

    public KuFangCreatedEvent(KuFangId kuFangId, KuFangName kuFangName) {
        log.info("新建：KuFangCreatedEvent");

        this.kuFangId = checkNotNull(kuFangId, "没有库房标识符！");
        this.kuFangName = checkNotNull(kuFangName, "没有库房名称！");
    }

    public static KuFangCreatedEvent create(KuFangId kuFangId, KuFangName kuFangName) {
        return new KuFangCreatedEvent(kuFangId, kuFangName);
    }
}

