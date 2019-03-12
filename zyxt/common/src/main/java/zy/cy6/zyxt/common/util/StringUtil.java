package zy.cy6.zyxt.common.util;

public class StringUtil {

    public static boolean isNullOrEmpty(String s) {

        return s == null || s.length() == 0;
    }

    public static boolean isNullOrWhitespace(String s) {
        return isNullOrEmpty(s) || isWhitespace(s);
    }

    public StringUtil() {
    }

    private static boolean isWhitespace(String s) {
//        return s.trim().length() == 0 ? true : false;
        return s.trim().length() == 0 ;
    }

    public static String notNullString(String s) {
        return isNullOrWhitespace(s) ? "" : s;
    }
}
