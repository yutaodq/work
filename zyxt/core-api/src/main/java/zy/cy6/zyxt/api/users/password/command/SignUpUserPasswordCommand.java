package zy.cy6.zyxt.api.users.password.command;

import lombok.Builder;
import lombok.Value;
import zy.cy6.zyxt.api.users.account.AccountId;

/*
 * 注册用户密码命令
 */
@Value
@Builder
public class SignUpUserPasswordCommand  {
    private String password;
    private AccountId accountId;
}
