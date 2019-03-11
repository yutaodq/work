package zy.cy6.zyxt.api.users.password.event;

import lombok.Builder;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import zy.cy6.zyxt.api.users.account.AccountId;
import zy.cy6.zyxt.api.users.user.UserPasswordId;

/*
 * 用户密码注册事件
 */
@Slf4j
@Builder
@Value
public class UserPasswordSignedUpEvent  {
    @TargetAggregateIdentifier
    private UserPasswordId userPasswordId;
    private String hashValue;
    private AccountId accountId;
}
