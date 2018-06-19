package zy.cy6.zyxt.common.domain;

import static org.axonframework.common.IdentifierFactory.getInstance;

public interface AggregateIdentifier {

  static String generateIdentifier() {
    return getInstance().generateIdentifier();
  }

  String identifier();
}
