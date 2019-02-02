package zy.cy6.zyxt.api.product.kufang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor

public class KufangRemovedEvent {
  private KufangId kufangId;
}
