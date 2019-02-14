package zy.cy6.zyxt.common.domain;

import lombok.EqualsAndHashCode;
import org.springframework.util.Assert;

import java.io.Serializable;

@EqualsAndHashCode
public abstract class AbstractAggregateIdentifier<T> implements AggregateIdentifier, Serializable {
    private final String identifier;

    public AbstractAggregateIdentifier() {
        this(AggregateIdentifier.generateIdentifier());
    }

    public AbstractAggregateIdentifier(String identifier) {
        this.identifier = identifier;
        this.checkIdentifier();
    }

    private void checkIdentifier() {
        Assert.hasLength(identifier, "标识不能为空或null");
//        checkNotNull(identifier, toString() + "不能是null！");
//        checkArgument(!identifier.trim().isEmpty(), toString() + "标识不能为空！");
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return  "identifier=" + getIdentifier();
    }

}
