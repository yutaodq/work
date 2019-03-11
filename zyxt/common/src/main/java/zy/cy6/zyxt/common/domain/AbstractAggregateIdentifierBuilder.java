package zy.cy6.zyxt.common.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public abstract class AbstractAggregateIdentifierBuilder<T, E> {
    private String identifier = UUID.randomUUID().toString();

    public T identifier(String identifier) {
        setIdentifier(identifier);
        return (T) this;
    }

    public E build() {
        return (E) createId();
    }

    abstract protected AggregateIdentifier createId();
}

/*
 * AbstractAggregateIdentifierBuilder 没有形参和抽象方法的使用说明
 */

//public static class KufangIdBuilder extends AbstractAggregateIdentifierBuilder {
//    public KufangIdBuilder identifier(String identifier) {
//        setIdentifier(identifier);
//        return this;
//    }
//
//    public KufangId build() {
//        return new KufangId(getIdentifier());
//    }
//
//}
