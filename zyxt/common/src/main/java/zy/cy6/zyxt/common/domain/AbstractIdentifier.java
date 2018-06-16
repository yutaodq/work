package zy.cy6.zyxt.common.domain;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractIdentifier implements Identifier, Serializable {
  private final String identifier;

  public AbstractIdentifier(String identifier) {
    //    checkNotNull(identifier, toString()+"不能是null！");
    //    checkArgument(!identifier.trim().isEmpty(), toString()+"标识不能为空！");
    this.identifier = identifier;
  }

  @Override
  public String identifier() {
    return identifier;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AbstractIdentifier)) return false;
    AbstractIdentifier that = (AbstractIdentifier) o;
    return Objects.equals(identifier, that.identifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier);
  }

  @Override
  public String toString() {
    return "AbstractIdentifier{" + "identifier='" + identifier + '\'' + '}';
  }
}
