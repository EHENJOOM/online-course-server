package com.zhk.service.impl;

import com.zhk.dao.TopicDao;
import com.zhk.entity.po.TopicPo;
import com.zhk.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Topic)表服务实现类
 *
 * @author 赵洪苛
 * @date 2020-08-23 16:59:10
 */
@Service("topicService")
public class TopicServiceImpl implements TopicService {
    @Resource
    private TopicDao topicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TopicPo getTopicById(Integer id) {
        return this.topicDao.getTopicById(id);
    }

    /**
     * 通过courseId查询数据
     *
     * @param courseId 课程ID
     * @return 对象列表
     */
    @Override
    public List<TopicPo> getTopicByCourse(Integer courseId) {
        return this.topicDao.getTopicByCourse(courseId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TopicPo> limit(int offset, int limit) {
        return this.topicDao.limit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param topicPo 实例对象
     * @return 实例对象
     */
    @Override
    public TopicPo insert(TopicPo topicPo) {
        this.topicDao.insert(topicPo);
        return topicPo;
    }

    /**
     * 修改数据
     *
     * @param topicPo 实例对象
     * @return 实例对象
     */
    @Override
    public TopicPo update(TopicPo topicPo) {
        this.topicDao.update(topicPo);
        return this.getTopicById(topicPo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.topicDao.deleteById(id) > 0;
    }
}