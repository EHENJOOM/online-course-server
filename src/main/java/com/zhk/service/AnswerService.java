package com.zhk.service;

import com.zhk.entity.po.AnswerPo;

import java.util.List;

/**
 * (Answer)表服务接口
 *
 * @author 赵洪苛
 * @date 2020-08-23 16:59:08
 */
public interface AnswerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AnswerPo getAnswerById(Integer id);

    /**
     * 通过topicId查询答疑信息
     *
     * @param topicId 主题ID
     * @return 对象列表
     */
    List<AnswerPo> getAnswerByTopic(Integer topicId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AnswerPo> limit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param answerPo 实例对象
     * @return 实例对象
     */
    AnswerPo insert(AnswerPo answerPo);

    /**
     * 修改数据
     *
     * @param answerPo 实例对象
     * @return 实例对象
     */
    AnswerPo update(AnswerPo answerPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}