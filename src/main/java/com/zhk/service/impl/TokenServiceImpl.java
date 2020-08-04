package com.zhk.service.impl;

import cn.hutool.core.util.IdUtil;
import com.zhk.config.Config;
import com.zhk.service.TokenService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author 赵洪苛
 * @date 2020/8/4 18:10
 * @description 客户端鉴权验证实现类
 */
@Service("tokenService")
public class TokenServiceImpl implements TokenService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 从缓存中获取token
     *
     * @param number 学号、工号
     * @return token字符串
     */
    @Override
    public String getToken(String number) {
        return stringRedisTemplate.opsForValue().get(number);
    }

    /**
     * 如果缓存中有token，则返回缓存中的，否则生成一个token，并存放到redis缓存中，且默认有效时间为60分钟
     * @param number 学号、工号
     * @return token字符串
     */
    @Override
    public String generateToken(String number) {
        String cache = stringRedisTemplate.opsForValue().get(number);
        if (cache != null) {
            return cache;
        }
        String token = IdUtil.simpleUUID();
        stringRedisTemplate.opsForValue().set(number, token, Config.TOKEN_LIVE_TIME, TimeUnit.MINUTES);
        return token;
    }

    /**
     * 验证token是否正确、过期
     * @param number 学号、工号
     * @param token token字符串
     * @return 验证结果
     */
    @Override
    public boolean verify(String number, String token) {
        String cache = stringRedisTemplate.opsForValue().get(number);
        if (token == null) {
            return false;
        }
        return Objects.equals(cache, token);
    }
}
