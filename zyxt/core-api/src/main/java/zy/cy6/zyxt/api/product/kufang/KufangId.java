package zy.cy6.zyxt.api.product.kufang;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import zy.cy6.zyxt.common.domain.AbstractAggregateIdentifier;

@Slf4j
@EqualsAndHashCode
public final class KufangId extends AbstractAggregateIdentifier {
    private KufangId() {
        super();
        log.info("新建库房标识：KufangId");
    }

    private KufangId(String identifier) {
        super(identifier);
        log.info("新建库房标识：KufangId");
    }

    public static KufangId create() {
        return new KufangId();
    }

    public static KufangId create(String identifier) {
        return new KufangId(identifier);
    }

        @Override
    public String toString() {
        return "库房标识:"+super.toString();
    }
}
