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
import org.apache.commons.lang3.StringUtils;
import zy.cy6.zyxt.query.users.shiro.base.utils.Consts;
import zy.cy6.zyxt.query.users.shiro.entity.Channel;
import zy.cy6.zyxt.query.users.shiro.entity.Post;
import zy.cy6.zyxt.query.users.shiro.entity.PostAttribute;

import java.io.Serializable;

/**
 * @author langhsu
 * 
 */
public class PostVO extends Post implements Serializable {
	private static final long serialVersionUID = -1144627551517707139L;

	private String editor;
	private String content;

	private UserVO author;
	private Channel channel;
	
	@JSONField(serialize = false)
	private PostAttribute attribute;
	
	public String[] getTagsArray() {
		if (StringUtils.isNotBlank(super.getTags())) {
			return super.getTags().split(Consts.SEPARATOR);
		}
		return null;
	}

	public UserVO getAuthor() {
		return author;
	}

	public void setAuthor(UserVO author) {
		this.author = author;
	}

	public PostAttribute getAttribute() {
		return attribute;
	}

	public void setAttribute(PostAttribute attribute) {
		this.attribute = attribute;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}
