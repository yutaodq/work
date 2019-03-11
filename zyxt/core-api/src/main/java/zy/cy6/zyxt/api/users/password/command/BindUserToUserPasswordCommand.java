package zy.cy6.zyxt.api.users.password.command;

import lombok.Builder;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import zy.cy6.zyxt.api.users.user.UserId;
import zy.cy6.zyxt.api.users.user.UserPasswordId;
/*
 * 将用户绑定到用户密码命令
 */
@Value
@Builder
public class BindUserToUserPasswordCommand {
    @TargetAggregateIdentifier
    private UserPasswordId userPasswordId;
    private UserId userId;
}
