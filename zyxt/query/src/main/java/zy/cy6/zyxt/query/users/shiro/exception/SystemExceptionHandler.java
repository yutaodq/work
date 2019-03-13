package zy.cy6.zyxt.query.users.shiro.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zy.cy6.zyxt.query.users.shiro.enums.REnum;
import zy.cy6.zyxt.query.users.shiro.utils.RUtil;
import zy.cy6.zyxt.query.users.shiro.vo.R;

/**
 * 异常处理器
 * author: 小宇宙
 * date: 2018/4/7
 */
@Slf4j
@RestControllerAdvice
public class SystemExceptionHandler {

    /**
     * 缺少权限异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(AuthorizationException.class)
    public R handleAuthorizationException(AuthorizationException e){
        log.error(REnum.NOT_PERMSSION.getMessage());
        return RUtil.error(REnum.NOT_PERMSSION.getCode(),REnum.NOT_PERMSSION.getMessage());
    }
}
