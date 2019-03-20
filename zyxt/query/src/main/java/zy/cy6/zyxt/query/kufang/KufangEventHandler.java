package zy.cy6.zyxt.query.kufang;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zy.cy6.zyxt.api.product.kufang.KufangCreatedEvent;
import zy.cy6.zyxt.api.product.kufang.KufangRemovedEvent;
import zy.cy6.zyxt.query.kufang.repositories.KufangQueryRepository;

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
  public void on(KufangCreatedEvent event) {
    KufangEntity kufangEntry = new KufangEntity();
    kufangEntry.setIdentifier(event.getKufangId().getIdentifier());
    kufangEntry.setName(event.getKufangName().getName());
    kufangEntry.setBz(event.getBz());
    log.info("KufangEventHandler:create:kuFangEntry实体的名称" + event.getKufangName().getName());

    repository.save(kufangEntry);
  }

//  @EventHandler
//  public void changeKuFangName(KufangNameChangedEvent event) {
//    log.info("修改：kuFangEntry实体的名称");
//    Optional<KufangEntity> kuFangEntry = repository.findByIdentifier(event.getKufangId().getIdentifier());
//    KufangEntity entity = kuFangEntry.get();
//    entity.setName(event.getKufangName().getName());
//    repository.save(entity);
//  }
  @EventHandler
  public void removedKufang(KufangRemovedEvent event) {
    long id = repository.findByIdentifier(event.getKufangId().getIdentifier()).get().getId();
    log.info("KufangQueryListener: kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");

    repository.deleteById(id);

  }
}
