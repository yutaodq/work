package zy.cy6.zyxt.api.product.kufang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Getter
@ToString
@AllArgsConstructor

public class KufangRemovedEvent {
  @TargetAggregateIdentifier
  private KufangId kufangId;
}
