package zy.cy6.zyxt.api.product.kufang;

import lombok.extern.slf4j.Slf4j;

import zy.cy6.zyxt.common.domain.AbstractAggregateIdentifier;
import zy.cy6.zyxt.common.domain.AbstractAggregateIdentifierBuilder;
import zy.cy6.zyxt.common.domain.AggregateIdentifier;

/*
 * 使用方法
 * KufangId.builder().identifier(id).build()
 * KufangId.builder().build()
 */
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
    public static class KufangIdBuilder extends AbstractAggregateIdentifierBuilder<KufangIdBuilder, KufangId> {
        protected AggregateIdentifier createId() {
            return new KufangId(getIdentifier());
        }
    }
}
