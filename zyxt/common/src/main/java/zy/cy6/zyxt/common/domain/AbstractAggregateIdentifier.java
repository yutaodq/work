package zy.cy6.zyxt.common.domain;

import lombok.EqualsAndHashCode;
import org.springframework.util.Assert;

import java.io.Serializable;

@EqualsAndHashCode
public abstract class AbstractAggregateIdentifier implements AggregateIdentifier, Serializable {
  private String identifier;

  public AbstractAggregateIdentifier() {
  }

  public AbstractAggregateIdentifier(String identifier) {
    this.identifier = identifier;
    this.checkIdentifier();
  }

  private void checkIdentifier() {
    Assert.hasLength(identifier, "标识不能为空或null");
  }

  @Override
  public String getIdentifier() {
    return this.identifier;
  }

  @Override
  public String toString() {
    return "identifier=" + getIdentifier();
  }

}

