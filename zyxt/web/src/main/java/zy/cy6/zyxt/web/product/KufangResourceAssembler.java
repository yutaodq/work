package zy.cy6.zyxt.web.product;

import org.springframework.stereotype.Component;
import zy.cy6.zyxt.common.hateoas.SimpleIdentifiableResourceAssembler;
import zy.cy6.zyxt.query.kufang.KufangEntity;
import zy.cy6.zyxt.web.controller.KufangController;


@Component
public class KufangResourceAssembler extends SimpleIdentifiableResourceAssembler<KufangEntity> {
    public KufangResourceAssembler() {
        super(KufangController.class);
    }

}


