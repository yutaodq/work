package zy.cy6.zyxt.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zy.cy6.zyxt.web.product.KufangService;
import zy.cy6.zyxt.web.users.UserService;
import zy.cy6.zyxt.web.util.Result;

@RestController
@Slf4j
@RequestMapping("/api")

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService ) {
        this.userService = userService;

    }

    @PostMapping(value = "/login")
    public Result login(USER) {
        log.info("你的应用程序配置错误!infoinfoinfoinfoinfoinfo。");
        return null;
    }
//    public Result login(String username, String password) {
//        log.info("你的应用程序配置错误!infoinfoinfoinfoinfoinfo。"                       );
//        return userService.login(username, password, false);
//    }

}
