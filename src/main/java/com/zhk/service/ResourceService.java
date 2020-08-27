package com.zhk.service;

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
     */
    void saveResource(Map resource, Integer courseId);

    /**
     * 根据课程ID查询资源列表
     *
     * @param courseId 课程ID
     * @return 资源列表
     */
    LinkedHashMap getResource(Integer courseId);

}
