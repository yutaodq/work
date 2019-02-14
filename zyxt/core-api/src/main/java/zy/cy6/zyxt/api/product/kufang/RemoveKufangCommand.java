package zy.cy6.zyxt.api.product.kufang;

import lombok.*;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
public class RemoveKufangCommand {
  @TargetAggregateIdentifier
  @NonNull
  private KufangId kufangId;
}
