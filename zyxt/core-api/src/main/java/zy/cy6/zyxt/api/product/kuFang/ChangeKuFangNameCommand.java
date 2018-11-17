package zy.cy6.zyxt.api.product.kuFang;

import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

@Value
public class ChangeKuFangNameCommand {
    @TargetAggregateIdentifier
    private KuFangId kuFangId;

    @NotNull(message = "工具名称对象不能为空")
    private KuFangName kuFangName;
}
