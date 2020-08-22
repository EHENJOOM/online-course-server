package com.zhk.service;

import com.zhk.entity.vo.ResourceVo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 赵洪苛
 * @date 2020/8/22 16:46
 * @description 资源服务层
 */
public interface ResourceService {

    /**
     * 以课程ID和教师ID为主键，唯一标识一个资源列表
     *
     * @param resource 资源
     * @param courseId 课程ID
     * @param teacherId 教师ID
     */
    void saveResource(Map resource, Integer courseId, Integer teacherId);

    /**
     * 根据课程ID和教师ID查询资源列表
     *
     * @param courseId 课程ID
     * @param teacherId 教师ID
     * @return 资源列表
     */
    LinkedHashMap getResource(Integer courseId, Integer teacherId);

}
