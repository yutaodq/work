package zy.cy6.zyxt.api.product.kuFang;

import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
public class KuFangNameChangedEvent {
    @TargetAggregateIdentifier
    private KuFangId kuFangId;
    private KuFangName kuFangName;

}
