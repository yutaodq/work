package zy.cy6.zyxt.api.product.kufang;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
@Value
@Builder
public class CreateKufangCommand {
    @TargetAggregateIdentifier
    @NonNull
    private KufangId kufangId;
    @NonNull
    private KufangName kufangName;
    private String bz;

}
