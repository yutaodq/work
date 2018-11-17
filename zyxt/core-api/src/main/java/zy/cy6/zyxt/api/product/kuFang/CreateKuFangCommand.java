package zy.cy6.zyxt.api.product.kuFang;

import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

@Value
public class CreateKuFangCommand {
    @NotNull(message = "库房标识对象不能为空")
    @TargetAggregateIdentifier
    private KuFangId kuFangId;

    @NotNull(message = "库房名称对象不能为空")
    private KuFangName kuFangName;

}
