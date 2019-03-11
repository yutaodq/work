package zy.cy6.zyxt.api.users.password.command;

import lombok.Builder;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import zy.cy6.zyxt.api.users.user.UserPasswordId;
/*
 * 删除用户密码命令
 */
@Value
@Builder
public class DeleteUserPasswordCommand {
    @TargetAggregateIdentifier
    private UserPasswordId userPasswordId;
}
