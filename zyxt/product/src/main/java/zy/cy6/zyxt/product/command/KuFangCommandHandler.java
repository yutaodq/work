package zy.cy6.zyxt.product.command;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.AggregateNotFoundException;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventhandling.EventBus;
import zy.cy6.zyxt.api.exception.DomainException;
import zy.cy6.zyxt.api.exception.ErrorCode;
import zy.cy6.zyxt.api.product.kuFang.ChangeKuFangNameCommand;
import zy.cy6.zyxt.api.product.kuFang.CreateKuFangCommand;
import zy.cy6.zyxt.api.product.kuFang.KuFangId;
import zy.cy6.zyxt.query.product.KuFangQueryService;

@Slf4j

public class KuFangCommandHandler {

    private Repository<KuFang> repository;
    private EventBus eventBus;
    private KuFangQueryService kuFangQueryService;

    public KuFangCommandHandler(Repository<KuFang> repository, EventBus eventBus, KuFangQueryService kuFangQueryService) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.kuFangQueryService = kuFangQueryService;
    }

    @CommandHandler
    public void handleChangeKuFangName(ChangeKuFangNameCommand command) throws Exception {
        log.info("ChangeKuFangNameCommand 命令处理器，在handleChangeKuFangName中执行的");
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
    public KuFangId handleCreateKuFang(CreateKuFangCommand command) throws Exception {
        kuFangQueryService.findByKuFangName(command.getKuFangName()).ifPresent(p -> {
            throw new DomainException(ErrorCode.VIOLATION_CONSTRAINT, "com.believe.bike.error.user.NotFound", "aaa");
        });

        KuFangId identifier = command.getKuFangId();
        repository.newInstance(() -> new KuFang(command));
        return identifier;
    }

}
