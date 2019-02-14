package zy.cy6.zyxt.api.product.kufang;

import lombok.Builder;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
@Builder

public class KufangNameChangedEvent {
    @TargetAggregateIdentifier
    private KufangId kufangId;
    private KufangName kufangName;

}
