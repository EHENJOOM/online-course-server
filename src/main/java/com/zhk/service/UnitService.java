package com.zhk.service;

import java.util.List;

/**
 * 单元学习服务层接口
 * @author 赵洪苛
 * @date 2020/8/23 15:27
 * @description 单元学习服务层接口
 */
public interface UnitService {

    /**
     * 以课程ID为主键，唯一标识一个单元
     *
     * @param resource 资源
     * @param courseId 课程ID
     */
    void saveUnit(List resource, Integer courseId);

    /**
     * 根据课程ID查询单元学习列表
     *
     * @param courseId 课程ID
     * @return 资源列表
     */
    List getUnit(Integer courseId);

}
