package zy.cy6.zyxt.api.product.kufang;

import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

@Value
public class CreateKufangCommand {
    @NotNull(message = "库房标识对象不能为空")
    @TargetAggregateIdentifier
    private KufangId kufangId;

    @NotNull(message = "库房名称对象不能为空")
    private KufangName kufangName;

}
