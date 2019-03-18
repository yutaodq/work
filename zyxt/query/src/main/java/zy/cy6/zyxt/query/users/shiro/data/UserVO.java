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

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import zy.cy6.zyxt.query.users.shiro.entity.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Setter
@Getter
public class UserVO implements Serializable {
	private static final long serialVersionUID = 107193816173103116L;

	private long id;
	private String username;

	@JSONField(serialize = false)
	private String password;
	private String avatar;
	private String name;
	private String email;

	private int posts; // 文章数
	private int comments; // 发布评论数

	private Date created;
	private Date lastLogin;
	private String signature; // 个性签名

	private int status;

	@JSONField(serialize = false)
	private List<Role> roles = new ArrayList<>();
}
