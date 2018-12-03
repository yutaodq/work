package zy.cy6.zyxt.api.product.kufang;

import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
public class KufangNameChangedEvent {
    @TargetAggregateIdentifier
    private KufangId kufangId;
    private KufangName kufangName;

}
