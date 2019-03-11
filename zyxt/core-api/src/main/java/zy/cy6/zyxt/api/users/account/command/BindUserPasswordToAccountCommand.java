package zy.cy6.zyxt.api.users.account.command;

import lombok.Builder;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import zy.cy6.zyxt.api.users.account.AccountId;
import zy.cy6.zyxt.api.users.user.UserPasswordId;

/*
 * 将用户密码绑定到帐户命令
 */
@Value
@Builder
public class BindUserPasswordToAccountCommand {
    @TargetAggregateIdentifier
    private AccountId accountId;

    private UserPasswordId userPasswordId;

    public BindUserPasswordToAccountCommand(AccountId accountId, UserPasswordId userPasswordId) {
        this.accountId = accountId;
        this.userPasswordId = userPasswordId;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public UserPasswordId getUserPasswordId() {
        return userPasswordId;
    }
}
