package zy.cy6.zyxt.query.users.shiro.utils;

/**
 * author: 小宇宙
 * date: 2018/4/7
 */
public class JPAUtil {

    public static String like(String column){
        StringBuilder sb = new StringBuilder("%"+column+"%");
        return sb.toString();
    }
}
