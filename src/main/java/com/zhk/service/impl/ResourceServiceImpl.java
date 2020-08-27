package com.zhk.service.impl;

import com.zhk.entity.vo.ResourceVo;
import com.zhk.service.ResourceService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 赵洪苛
 * @date 2020/8/22 16:49
 * @description 资源服务层实现类
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 以课程ID和教师ID为主键，唯一标识一个资源列表
     *
     * @param resource 资源
     * @param courseId   课程ID
     */
    @Override
    public void saveResource(Map resource, Integer courseId) {
        redisTemplate.opsForValue().set("res-cou-tea-" + courseId, resource);
    }

    /**
     * 根据课程ID和教师ID查询资源列表
     *
     * @param courseId  课程ID
     * @return 资源列表
     */
    @Override
    public LinkedHashMap getResource(Integer courseId) {
        return (LinkedHashMap) redisTemplate.opsForValue().get("res-cou-tea-" + courseId);
    }
}
