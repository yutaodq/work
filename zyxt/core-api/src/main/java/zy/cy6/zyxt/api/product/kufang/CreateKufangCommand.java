package zy.cy6.zyxt.api.product.kufang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Getter
@ToString
@AllArgsConstructor
public class CreateKufangCommand {
    @TargetAggregateIdentifier
    private KufangId kufangId;
    private KufangName kufangName;
    private String bz;

}
