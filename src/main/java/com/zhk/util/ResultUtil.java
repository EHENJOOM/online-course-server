package com.zhk.util;

import com.zhk.config.Config;
import com.zhk.entity.vo.CommonResultVo;

/**
 * @author 赵洪苛
 * @date 2020/7/30 21:04
 * @description 返回结果工具类
 */
public class ResultUtil {

    /**
     * 服务成功返回给客户端的数据对象
     * @param data 服务数据
     * @param <T> 携带的数据类型
     * @return {@link CommonResultVo}
     */
    public static <T> CommonResultVo<T> success(T data) {
        return new CommonResultVo<>(Config.SUCCESS, Config.SUCCESS_STRING, data);
    }

    /**
     * 服务失败返回给客户的数据对象
     * @param code 错误码
     * @param msg 错误提示
     * @param <T> 携带的数据类型
     * @return {@link CommonResultVo}
     */
    public static <T> CommonResultVo<T> error(int code, String msg) {
        return error(code, msg, null);
    }

    /**
     * 服务失败返回给客户的数据对象
     * @param code 错误码
     * @param msg 错误提示
     * @param data 携带的数据
     * @param <T> 携带的数据类型
     * @return {@link CommonResultVo}
     */
    public static <T> CommonResultVo<T> error(int code, String msg, T data) {
        return new CommonResultVo<>(code, msg, data);
    }

    public static <T> CommonResultVo<T> exception(String msg, T data) {
        return new CommonResultVo<>(Config.SERVER_ERROR, msg, data);
    }

}
