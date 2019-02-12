package zy.cy6.zyxt.product.kufang.command;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import zy.cy6.zyxt.api.product.kufang.*;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/*
事件溯源聚合的聚合根还必须包含一个无参的构造函数，用@NoArgsConstructor这个构造函数。
，Axon Framework使用这个构造函数创建一个空的聚合实例，
在使用过去的事件之前初始化它。没有提供这种构造函数加载聚合时将导致异常
 */
@Aggregate
@Slf4j
@NoArgsConstructor  //Axon Framework 要求聚合根必需有无参数的构造函数

public class Kufang {
  @AggregateIdentifier
  private KufangId kuFangId;
  private KufangName kuFangName;
//  private String bz;

//  public Kufang() {
//    //Axon Framework 要求聚合根必需有无参数的构造函数
//  }

  @CommandHandler
  public Kufang(CreateKufangCommand command) {
    apply(KufangCreatedEvent.create(command.getKufangId(), command.getKufangName(), command.getBz()));
  }

  @CommandHandler
  public void handle(RemoveKufangCommand cmd) {
    log.info("aaaaaaaaaa");
//    apply(new KufangRemovedEvent(cmd.getKufangId()));
  }
public void remove(){
  log.info("删除kufang记录，在聚合kufang中");

}

  @SuppressWarnings("UnusedDeclaration")
  @EventSourcingHandler
  public void on(KufangCreatedEvent event) {
    this.kuFangId = event.getKuFangId();
//    this.kuFangName = event.getKuFangName();
//    this.bz = event.getBz();
  }
  @EventSourcingHandler
  public void on(KufangRemovedEvent event) {
    log.info("Done handling {} event: {}", event.getClass().getSimpleName(), event);
  }

  public void changeKufangName(KufangName kuFangName) {
    apply(new KufangNameChangedEvent(kuFangId, kuFangName));
  }

  @SuppressWarnings("UnusedDeclaration")
  @EventSourcingHandler
  public void on(KufangNameChangedEvent event) {
    this.kuFangName = event.getKufangName();
  }

}
