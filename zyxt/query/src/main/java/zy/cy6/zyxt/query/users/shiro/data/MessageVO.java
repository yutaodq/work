package zy.cy6.zyxt.query.users.shiro.data;


import zy.cy6.zyxt.query.users.shiro.entity.Message;

/**
 * @author langhsu on 2015/8/31.
 */
public class MessageVO extends Message {
    // extend
    private UserVO from;
    private PostVO post;

    public UserVO getFrom() {
        return from;
    }

    public void setFrom(UserVO from) {
        this.from = from;
    }

    public PostVO getPost() {
        return post;
    }

    public void setPost(PostVO post) {
        this.post = post;
    }
}
