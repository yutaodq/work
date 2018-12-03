package zy.cy6.zyxt.common.domain;
import java.util.UUID;
public interface AggregateIdentifier {
  static String generateIdentifier() {
    return UUID.randomUUID().toString();
  }
  String getIdentifier();
}
