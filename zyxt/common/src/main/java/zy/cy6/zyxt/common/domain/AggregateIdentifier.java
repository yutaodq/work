package zy.cy6.zyxt.common.domain;
import org.springframework.util.Assert;

import java.util.UUID;
public interface AggregateIdentifier<T> {
//  static String generateIdentifier() {
//    return UUID.randomUUID().toString();
//  }
  String getIdentifier();
}
