package zy.cy6.zyxt.common.domain;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@EqualsAndHashCode
public abstract class AbstractIdentifier implements Identifier, Serializable {
  private final String identifier;

  public AbstractIdentifier() {
    this(Identifier.generateIdentifier());
  }

  public AbstractIdentifier(String identifier) {
    this.identifier = identifier;
    checkIdentifier();
  }

  private void checkIdentifier() {
    checkNotNull(identifier, toString() + "不能是null！");
    checkArgument(!identifier.trim().isEmpty(), toString() + "标识不能为空！");
  }

  @Override
  public String identifier() {
    return identifier;
  }

  @Override
  public String toString() {
    return "AbstractIdentifier{" + "identifier='" + identifier + '\'' + '}';
  }
}
