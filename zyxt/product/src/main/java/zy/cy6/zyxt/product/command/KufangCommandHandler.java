package zy.cy6.zyxt.product.command;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.AggregateNotFoundException;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventhandling.EventBus;
import zy.cy6.zyxt.api.exception.DomainException;
import zy.cy6.zyxt.api.exception.ErrorCode;
import zy.cy6.zyxt.api.product.kufang.ChangeKufangNameCommand;
import zy.cy6.zyxt.api.product.kufang.CreateKufangCommand;
import zy.cy6.zyxt.api.product.kufang.KufangId;
import zy.cy6.zyxt.query.product.KufangQueryService;
@Slf4j
public class KufangCommandHandler {

    private Repository<Kufang> repository;
    private EventBus eventBus;
    private KufangQueryService kuFangQueryService;

    public KufangCommandHandler(Repository<Kufang> repository, EventBus eventBus, KufangQueryService kufangQueryService) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.kuFangQueryService = kufangQueryService;
    }

    @CommandHandler
    public void handleChangeKufangName(ChangeKufangNameCommand command) throws Exception {
        try {
            Aggregate<Kufang> kufangAggregate = repository.load(command.getKufangId().getIdentifier());
            kufangAggregate.execute(kufang -> kufang.changeKufangName(command.getKufangName()));
        } catch (AggregateNotFoundException exception) {
            //        eventBus.publish(asEventMessage(new
            // SourceBankAccountNotFoundEvent(command.getBankTransferId())));

        }
    }

    @CommandHandler
    public KufangId handlecreatekufang(CreateKufangCommand command) throws Exception {
        kuFangQueryService.findByKuFangName(command.getKufangName()).ifPresent(p -> {
            throw new DomainException(ErrorCode.VIOLATION_CONSTRAINT, "com.believe.bike.error.user.NotFound", "aaa");
        });

        KufangId identifier = command.getKufangId();
        repository.newInstance(() -> new Kufang(command));
        return identifier;
    }

}
