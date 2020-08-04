package com.zhk.service;

/**
 * 根据不同用户生成token并缓存，验证token是否正确、过期
 * @author 赵洪苛
 * @date 2020/8/4 18:05
 * @description 客户端鉴权验证服务
 */
public interface TokenService {

    /**
     * 从缓存中获取token
     * @param number 学号、工号
     * @return token字符串
     */
    String getToken(String number);

    /**
     * 生成一个token，并存放到redis缓存中
     * @param number 学号、工号
     * @return token字符串
     */
    String generateToken(String number);

    /**
     * 验证token是否正确、过期
     * @param number 学号、工号
     * @param token token字符串
     * @return 验证结果
     */
    boolean verify(String number, String token);

}
