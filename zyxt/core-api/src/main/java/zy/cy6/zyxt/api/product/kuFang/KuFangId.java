package zy.cy6.zyxt.api.product.kuFang;

import lombok.extern.slf4j.Slf4j;
import zy.cy6.zyxt.common.domain.AbstractAggregateIdentifier;

@Slf4j
//@EqualsAndHashCode

public final class KufangId extends AbstractAggregateIdentifier {

    private KufangId() {
        super();
        log.info("新建：KufangId");
    }

    private KufangId(String identifier) {
        super(identifier);
        log.info("新建：KufangId");
    }

    public static KufangId create() {
        return new KufangId();
    }

    public static KufangId create(String identifier) {
        return new KufangId(identifier);
    }

    @Override
    public String toString() {
        return "库房标识{" + "identifier='" + getIdentifier() + '\'' + '}';
    }
}
