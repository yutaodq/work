package zy.cy6.zyxt.web.users;

import zy.cy6.zyxt.web.util.Result;

public interface UserService {
    Result login(String username, String password, boolean rememberMe);
}
