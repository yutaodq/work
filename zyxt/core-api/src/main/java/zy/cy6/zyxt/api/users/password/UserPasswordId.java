package zy.cy6.zyxt.api.users.user;

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
public final class UserPasswordId extends AbstractAggregateIdentifier {
    private UserPasswordId(String identifier) {
        super(identifier);
        log.info("新建库房标识：UserPasswordId");
    }

    public static UserPasswordIdBuilder builder() {
        return new UserPasswordIdBuilder();
    }

    @Override
    public String toString() {
        return "库房标识:" + super.toString();
    }

    /*
     * 静态类
     */
    public static class UserPasswordIdBuilder extends AbstractAggregateIdentifierBuilder<UserPasswordIdBuilder, UserPasswordId> {
        protected AggregateIdentifier createId() {
            return new UserPasswordId(getIdentifier());
        }
    }

}
