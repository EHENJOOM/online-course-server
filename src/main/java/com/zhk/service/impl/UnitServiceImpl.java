package com.zhk.service.impl;

import com.zhk.service.UnitService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 赵洪苛
 * @date 2020/8/23 15:29
 * @description 单元学习服务层实现类
 */
@Service("unitService")
public class UnitServiceImpl implements UnitService {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 以课程ID为主键，唯一标识一个单元
     *
     * @param unit 单元
     * @param courseId 课程ID
     */
    @Override
    public void saveUnit(List unit, Integer courseId) {
        this.redisTemplate.opsForValue().set("unit-course-" + courseId, unit);
    }

    /**
     * 根据课程ID查询单元学习列表
     *
     * @param courseId 课程ID
     * @return 单元列表
     */
    @Override
    public List getUnit(Integer courseId) {
        return (List) this.redisTemplate.opsForValue().get("unit-course-" + courseId);
    }
}
