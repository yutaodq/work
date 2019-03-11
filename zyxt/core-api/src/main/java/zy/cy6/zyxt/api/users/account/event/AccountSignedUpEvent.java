package zy.cy6.zyxt.api.users.account.event;

import lombok.Builder;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import zy.cy6.zyxt.api.users.account.AccountId;

/*
 * 帐号注册事件
 */
@Slf4j
@Builder
@Value
public class AccountSignedUpEvent{
    @AggregateIdentifier
    private AccountId accountId;

}
