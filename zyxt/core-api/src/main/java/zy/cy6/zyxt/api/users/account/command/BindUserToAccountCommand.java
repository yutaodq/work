package zy.cy6.zyxt.api.users.account.command;

import lombok.Builder;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import zy.cy6.zyxt.api.users.account.AccountId;
import zy.cy6.zyxt.api.users.user.UserId;

/*
 * 将用户绑定到帐户命令
 */
@Value
@Builder

public class BindUserToAccountCommand {
    @TargetAggregateIdentifier
    private AccountId accountId;
    private UserId userId;

}
