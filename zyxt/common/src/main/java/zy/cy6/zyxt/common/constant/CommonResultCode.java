package zy.cy6.zyxt.common.constant;

public interface CommonResultCode {
    // 处理成功
    public static final int SUCCESS = 20000;

    // 参数有误
    public static final int INVALID_COMMAND_PARAMS = 40000;

    // 无权限访问
    public static final int FORBIDDEN = 40300;

    // 服务未知错误
    public static final int UNKNOWN_EXCEPTION = 50000;
}
