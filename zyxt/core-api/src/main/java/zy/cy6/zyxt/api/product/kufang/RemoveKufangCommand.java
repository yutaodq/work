package zy.cy6.zyxt.api.product.kufang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Getter
@ToString
//@AllArgsConstructor
public class RemoveKufangCommand {
  @TargetAggregateIdentifier
  private KufangId kufangId;

  public RemoveKufangCommand(KufangId kufangId) {
    this.kufangId = kufangId;
  }
}
