package zy.cy6.zyxt.api.product.kufang;

import lombok.Builder;
import lombok.NonNull;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Builder
public class CreateKufangCommand {
    @TargetAggregateIdentifier
    @NonNull
    private KufangId kufangId;
    @NonNull
    private KufangName kufangName;
    private String bz;

}
