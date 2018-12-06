package zy.cy6.zyxt.query.product;


import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zy.cy6.zyxt.api.product.kufang.KufangCreatedEvent;
import zy.cy6.zyxt.api.product.kufang.KufangNameChangedEvent;
import zy.cy6.zyxt.query.product.repositories.KufangQueryRepository;

import java.util.Optional;


@Component
@Slf4j
public class KufangQueryListener {
    private KufangQueryRepository repository;

    
    @EventHandler
  public void handleKuFangCreatedEvent(KufangCreatedEvent event)  {
        create(event);
    }


    private void create(KufangCreatedEvent event) {
        KufangEntity kuFangEntry = new KufangEntity();
        kuFangEntry.setIdentifier(event.getKuFangId().getIdentifier());
        kuFangEntry.setName(event.getKuFangName().getName());
        repository.save(kuFangEntry);
    }
    @EventHandler
    public void changeKuFangName(KufangNameChangedEvent event) {
        log.info("修改：kuFangEntry实体的名称");
        Optional<KufangEntity> kuFangEntry = repository.findByIdentifier(event.getKufangId().getIdentifier());
        KufangEntity entity = kuFangEntry.get();
        entity.setName(event.getKufangName().getName());
        repository.save(entity);
    }

    @Autowired
    public void setRepository(KufangQueryRepository repository) {
        this.repository = repository;
    }
}
