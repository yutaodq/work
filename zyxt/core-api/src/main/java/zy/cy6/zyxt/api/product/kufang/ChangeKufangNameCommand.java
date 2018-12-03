package zy.cy6.zyxt.api.product.kufang;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

@Value
public class ChangeKufangNameCommand {
    @TargetAggregateIdentifier
    private KufangId kufangId;

    @NotNull(message = "工具名称对象不能为空")
    private KufangName kufangName;
}
