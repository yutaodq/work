package zy.cy6.zyxt.query.kufang;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zy.cy6.zyxt.api.product.kufang.KufangCreatedEvent;
import zy.cy6.zyxt.api.product.kufang.KufangNameChangedEvent;
import zy.cy6.zyxt.api.product.kufang.KufangRemovedEvent;
import zy.cy6.zyxt.query.kufang.repositories.KufangQueryRepository;

import java.util.Optional;

@Service
//@ProcessingGroup("queryModel")
@Slf4j
public class KufangEventHandler {
  private final KufangQueryRepository repository;

  @Autowired
  public KufangEventHandler(KufangQueryRepository repository) {
    this.repository = repository;
  }

  @EventHandler
  public void handleKuFangCreatedEvent(KufangCreatedEvent event) {
    create(event);
  }

  private void create(KufangCreatedEvent event) {
    KufangEntity kuFangEntry = new KufangEntity();
    kuFangEntry.setIdentifier(event.getKuFangId().getIdentifier());
    kuFangEntry.setName(event.getKuFangName().getName());
    kuFangEntry.setBz(event.getBz());
    log.info("KufangEventHandler:create:kuFangEntry实体的名称" + event.getBz());

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
  @EventHandler
  public void removedKufang(KufangRemovedEvent event) {
    long id = repository.findByIdentifier(event.getKufangId().getIdentifier()).get().getId();
    log.info("KufangQueryListener: kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    repository.deleteById(id);

  }
}
