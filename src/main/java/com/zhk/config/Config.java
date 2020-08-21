package com.zhk.config;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
     * 作业尚未提交
     */
    public static int NOT_SUBMIT = 111;

    /**
     * 作业已提交，但尚未批阅
     */
    public static int NOT_CHECK = 112;

    /**
     * 作业已批阅
     */
    public static int CHECKED = 113;

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
     * 没有匹配的数据
     */
    public static int NO_DATA = 501;

    /**
     * token有效时间，默认为60分钟
     */
    public static long TOKEN_LIVE_TIME = 60;

    public static String SUCCESS_STRING = "成功";

    private static final String[] ACADEMY = {"化学工程学院", "材料科学与工程学院", "机电工程学院",
            "信息科学与技术学院", "经济管理学院", "化学学院", "数理学院", "文法学院", "生命科学与技术学院"};

    public static List<String> ACADEMIES = Arrays.asList(ACADEMY);


}
