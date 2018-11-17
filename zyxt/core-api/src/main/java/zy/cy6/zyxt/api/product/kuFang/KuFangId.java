package zy.cy6.zyxt.api.product.kuFang;

import lombok.extern.slf4j.Slf4j;
import zy.cy6.zyxt.common.domain.AbstractAggregateIdentifier;

@Slf4j
//@EqualsAndHashCode

public final class KuFangId extends AbstractAggregateIdentifier {

    private KuFangId() {
        super();
        log.info("新建：KuFangId");
    }

    private KuFangId(String identifier) {
        super(identifier);
        log.info("新建：KuFangId");
    }

    public static KuFangId create() {
        return new KuFangId();
    }

    public static KuFangId create(String identifier) {
        return new KuFangId(identifier);
    }

    @Override
    public String toString() {
        return "库房标识{" + "identifier='" + getIdentifier() + '\'' + '}';
    }
}
