package zy.cy6.zyxt.api.product.kufang;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

@Value
@Builder
public class ChangeKufangNameCommand {
    @TargetAggregateIdentifier
    @NonNull
    private KufangId kufangId;
    @NonNull
    private KufangName kufangName;
}
