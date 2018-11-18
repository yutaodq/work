package zy.cy6.zyxt.product.command;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.AggregateNotFoundException;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventhandling.EventBus;
import zy.cy6.zyxt.api.exception.DomainException;
import zy.cy6.zyxt.api.exception.ErrorCode;
import zy.cy6.zyxt.api.product.kuFang.ChangeKufangNameCommand;
import zy.cy6.zyxt.api.product.kuFang.CreateKufangCommand;
import zy.cy6.zyxt.api.product.kuFang.KufangId;
import zy.cy6.zyxt.query.product.KufangQueryService;

@Slf4j

public class KuFangCommandHandler {

    private Repository<KuFang> repository;
    private EventBus eventBus;
    private KufangQueryService kuFangQueryService;

    public KuFangCommandHandler(Repository<KuFang> repository, EventBus eventBus, KufangQueryService kuFangQueryService) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.kuFangQueryService = kuFangQueryService;
    }

    @CommandHandler
    public void handleChangeKuFangName(ChangeKufangNameCommand command) throws Exception {
        log.info("ChangeKufangNameCommand 命令处理器，在handleChangeKuFangName中执行的");
        try {
            Aggregate<KuFang> kuFangAggregate = repository.load(command.getKuFangId().getIdentifier());
            kuFangAggregate.execute(kuFang -> kuFang.changeKuFangName(command.getKuFangName()));
            log.info("aaaaaaaaaaaaaaa:" + command.getKuFangId().getIdentifier());
        } catch (AggregateNotFoundException exception) {
            log.info("bbbbbbbbbbbbbbbbbbbbbbbb:" + command.getKuFangId().toString());

            //        eventBus.publish(asEventMessage(new
            // SourceBankAccountNotFoundEvent(command.getBankTransferId())));

        }
    }

    @CommandHandler
    public KufangId handleCreateKuFang(CreateKufangCommand command) throws Exception {
        kuFangQueryService.findByKuFangName(command.getKufangName()).ifPresent(p -> {
            throw new DomainException(ErrorCode.VIOLATION_CONSTRAINT, "com.believe.bike.error.user.NotFound", "aaa");
        });

        KufangId identifier = command.getKufangId();
        repository.newInstance(() -> new KuFang(command));
        return identifier;
    }

}
