package zy.cy6.zyxt.api.product.kuFang;

import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
public class KufangNameChangedEvent {
    @TargetAggregateIdentifier
    private KufangId kufangId;
    private KufangName kufangName;

}
