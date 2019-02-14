package zy.cy6.zyxt.product.kufang.command;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.AggregateNotFoundException;
import org.axonframework.commandhandling.model.Repository;
import zy.cy6.zyxt.api.product.kufang.ChangeKufangNameCommand;
import zy.cy6.zyxt.api.product.kufang.CreateKufangCommand;
import org.axonframework.eventhandling.EventBus;
import zy.cy6.zyxt.api.product.kufang.RemoveKufangCommand;

@Slf4j
public class KufangCommandHandler {
//    private Repository<Kufang> repository;
//    private EventBus eventBus;
//
//    public KufangCommandHandler(Repository<Kufang> repository, EventBus eventBus) {
//        this.repository = repository;
//        this.eventBus = eventBus;
//    }
//    @CommandHandler
//    public void handle(RemoveKufangCommand command) {
//        try {
//            Aggregate<Kufang> kufangAggregate = repository.load(command.getKufangId().getIdentifier());
//            kufangAggregate.execute(kufang -> kufang.remove());
//        }
//        catch (AggregateNotFoundException exception) {
////            eventBus.publish(asEventMessage(new DestinationBankAccountNotFoundEvent(command.getBankTransferId())));
//        }
//    }
///*  参照 BankAccountCommandHandler 以下项目
//    <groupId>org.axonframework.samples</groupId>
//    <artifactId>axon-bank</artifactId>
//
// */
//    @CommandHandler
//    public void handleChangeKufangName(ChangeKufangNameCommand command) throws Exception {
//        try {
//            Aggregate<Kufang> kufangAggregate = repository.load(command.getKufangId().getIdentifier());
//            kufangAggregate.execute(kufang -> kufang.changeKufangName(command.getKufangName()));
//        } catch (AggregateNotFoundException exception) {
//            //        eventBus.publish(asEventMessage(new
//            // SourceBankAccountNotFoundEvent(command.getBankTransferId())));
//
//        }
//    }
//
////    @CommandHandler
//    public void handlecreatekufang(CreateKufangCommand command) throws Exception {
////        kuFangQueryService.findByKuFangName(command.getKufangName()).ifPresent(p -> {
////            throw new DomainException(ErrorCode.VIOLATION_CONSTRAINT, "com.believe.bike.error.user.NotFound", "aaa");
////        });
////
////        KufangId identifier = command.getKufangId();
//        repository.newInstance(() -> new Kufang(command));
//    }
////    @CommandHandler
////    public void handle(RemoveKufangCommand cmd) {
////        log.info("aaaaaaaaaa");
//////    apply(new KufangRemovedEvent(cmd.getKufangId()));
////    }
//
////    @Autowired
////    @Qualifier("kufangAggregateRepository")
////    public void setRepository(Repository<Kufang> kufangAggregateRepository) {
////        this.repository = kufangAggregateRepository;
////    }

}
