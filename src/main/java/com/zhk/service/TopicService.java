package com.zhk.service;

import com.zhk.entity.po.TopicPo;

import java.util.List;

/**
 * (Topic)表服务接口
 *
 * @author 赵洪苛
 * @date 2020-08-23 16:59:10
 */
public interface TopicService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TopicPo getTopicById(Integer id);

    /**
     * 通过courseId查询数据
     *
     * @param courseId 课程ID
     * @return 对象列表
     */
    List<TopicPo> getTopicByCourse(Integer courseId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TopicPo> limit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param topicPo 实例对象
     * @return 实例对象
     */
    TopicPo insert(TopicPo topicPo);

    /**
     * 修改数据
     *
     * @param topicPo 实例对象
     * @return 实例对象
     */
    TopicPo update(TopicPo topicPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}