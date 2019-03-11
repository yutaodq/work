package zy.cy6.zyxt.api.users.account.command;

import lombok.Builder;
import lombok.Value;
import zy.cy6.zyxt.api.users.account.AccountId;

/*
 * 注册帐户命令
 */
@Value
@Builder

public class SignUpAccountCommand {
    private AccountId accountId;
}