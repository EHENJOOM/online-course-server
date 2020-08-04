package com.zhk.config;

/**
 * @author 赵洪苛
 * @date 2020/7/30 21:05
 * @description 全局配置类
 */
public class Config {

    /**
     * 学生类型账户
     */
    public static int USER_STUDENT = 101;

    /**
     * 老师类型账户
     */
    public static int USER_TEACHER = 102;

    /**
     * 教务老师类型账户
     */
    public static int USER_OFFICER = 103;

    /**
     * 系统管理员类型账户
     */
    public static int USER_ADMIN = 104;

    public static int SUCCESS = 200;

    public static int INTERFACE_BUSY = 301;

    public static int OPERATE_FAIL = 302;

    /**
     * 不被授权的访问
     */
    public static int NOT_AUTHORIZE = 405;

    /**
     * 服务器抛出异常
     */
    public static int SERVER_ERROR = 500;

    /**
     * token有效时间，默认为60分钟
     */
    public static long TOKEN_LIVE_TIME = 60;

    public static String SUCCESS_STRING = "成功";

}
