package com.zhk.service.impl;

import com.zhk.dao.AnswerDao;
import com.zhk.entity.po.AnswerPo;
import com.zhk.service.AnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Answer)表服务实现类
 *
 * @author 赵洪苛
 * @date 2020-08-23 16:59:08
 */
@Service("answerService")
public class AnswerServiceImpl implements AnswerService {
    @Resource
    private AnswerDao answerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AnswerPo getAnswerById(Integer id) {
        return this.answerDao.getAnswerById(id);
    }

    /**
     * 通过topicId查询答疑信息
     *
     * @param topicId 主题ID
     * @return 对象列表
     */
    @Override
    public List<AnswerPo> getAnswerByTopic(Integer topicId) {
        return null;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AnswerPo> limit(int offset, int limit) {
        return this.answerDao.limit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param answerPo 实例对象
     * @return 实例对象
     */
    @Override
    public AnswerPo insert(AnswerPo answerPo) {
        this.answerDao.insert(answerPo);
        return answerPo;
    }

    /**
     * 修改数据
     *
     * @param answerPo 实例对象
     * @return 实例对象
     */
    @Override
    public AnswerPo update(AnswerPo answerPo) {
        this.answerDao.update(answerPo);
        return this.getAnswerById(answerPo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.answerDao.deleteById(id) > 0;
    }
}