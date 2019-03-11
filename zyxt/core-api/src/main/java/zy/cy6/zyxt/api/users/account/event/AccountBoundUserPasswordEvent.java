package zy.cy6.zyxt.api.users.account.event;

import lombok.Builder;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import zy.cy6.zyxt.api.users.account.AccountId;
import zy.cy6.zyxt.api.users.user.UserPasswordId;

/*
 * 帐户绑定用户密码事件
 */
@Slf4j
@Builder
@Value
public class AccountBoundUserPasswordEvent {
    @TargetAggregateIdentifier
    private AccountId accountId;
    private UserPasswordId userPasswordId;

}
