package zy.cy6.zyxt.api.users.account.event;

import lombok.Builder;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import zy.cy6.zyxt.api.users.account.AccountId;
import zy.cy6.zyxt.api.users.user.UserId;

/*
 * 帐户绑定用户事件
 */
@Slf4j
@Builder
@Value

public class AccountBoundUserEvent {
    @TargetAggregateIdentifier
    private AccountId accountId;

    private UserId userId;

}
