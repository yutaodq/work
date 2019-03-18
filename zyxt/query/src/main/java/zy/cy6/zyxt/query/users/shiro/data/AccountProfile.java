/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package zy.cy6.zyxt.query.users.shiro.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author langhsu
 * 帐户资料
 */
@Setter
@Getter
public class AccountProfile implements Serializable {
    private static final long serialVersionUID = 1748764917028425871L;
    private long id;
    private String username;
    private String avatar;  //头像
    private String name;
    private String email;

    private Date lastLogin;  //最后登录日期
    private int status;

    private BadgesCount badgesCount;

    public AccountProfile(long id, String username) {
        this.id = id;
        this.username = username;
    }

}
