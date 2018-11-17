package zy.cy6.zyxt.query.product;


import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zy.cy6.zyxt.api.product.kuFang.KuFangCreatedEvent;
import zy.cy6.zyxt.api.product.kuFang.KuFangNameChangedEvent;
import zy.cy6.zyxt.query.product.repositories.KuFangQueryRepository;

import java.util.Optional;


@Component
@Slf4j
public class KuFangQueryListener {
    private KuFangQueryRepository repository;

    @EventHandler
  public void handleKuFangCreatedEvent(KuFangCreatedEvent event)  {
        create(event);
    }


    private void create(KuFangCreatedEvent event) {
        KuFangEntity kuFangEntry = new KuFangEntity();
        kuFangEntry.setIdentifier(event.getKuFangId().getIdentifier());
        kuFangEntry.setName(event.getKuFangName().getName());
        repository.save(kuFangEntry);
    }
    @EventHandler
    public void changeKuFangName(KuFangNameChangedEvent event) {
        log.info("修改：kuFangEntry实体的名称");
        Optional<KuFangEntity> kuFangEntry = repository.findByIdentifier(event.getKuFangId().getIdentifier());
        KuFangEntity entity = kuFangEntry.get();
        entity.setName(event.getKuFangName().getName());
        repository.save(entity);
    }

    @Autowired
    public void setRepository(KuFangQueryRepository repository) {
        this.repository = repository;
    }
}
