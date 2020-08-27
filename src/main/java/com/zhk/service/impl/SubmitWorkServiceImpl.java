package com.zhk.service.impl;

import com.zhk.dao.SubmitWorkDao;
import com.zhk.entity.po.SubmitWorkPo;
import com.zhk.service.SubmitWorkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SubmitWork)表服务实现类
 *
 * @author 赵洪苛
 * @date 2020-08-19 16:11:14
 */
@Service("submitWorkService")
public class SubmitWorkServiceImpl implements SubmitWorkService {
    @Resource
    private SubmitWorkDao submitWorkDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubmitWorkPo getSubmitWorkById(Integer id) {
        return this.submitWorkDao.getSubmitWorkById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SubmitWorkPo> limit(int offset, int limit) {
        return this.submitWorkDao.limit(offset, limit);
    }

    /**
     * 通过workId查询提交的数据实例
     *
     * @param workId WorkPo主键
     * @return 对象列表
     */
    @Override
    public List<SubmitWorkPo> getSubmitWorkByWorkId(Integer workId) {
        return this.submitWorkDao.getSubmitWorkByWorkId(workId);
    }

    /**
     * 通过StudentId查询数据
     *
     * @param studentId 学生ID
     * @param courseId 课程ID
     * @return 对象列表
     */
    @Override
    public List<SubmitWorkPo> getSubmitWorkByStudentAndCourse(Integer studentId, Integer courseId) {
        return this.submitWorkDao.getSubmitWorkByStudentAndCourse(studentId, courseId);
    }

    /**
     * 通过workId获取数据独享
     *
     * @param workId 作业ID
     * @param offset 偏移
     * @param limit  指定条数据
     * @return 对象列表
     */
    @Override
    public List<SubmitWorkPo> getSubmitWorkByWorkAndLimit(Integer workId, Integer offset, Integer limit) {
        return this.submitWorkDao.getSubmitWorkByWorkAndLimit(workId, offset, limit);
    }

    /**
     * 计算负荷workId的数据条数
     *
     * @param workId 作业ID
     * @return 总数
     */
    @Override
    public Integer countSubmitWorkByWorkAndLimit(Integer workId) {
        return this.submitWorkDao.countSubmitWorkByWorkAndLimit(workId);
    }

    /**
     * 新增数据
     *
     * @param submitWorkPo 实例对象
     * @return 实例对象
     */
    @Override
    public SubmitWorkPo insert(SubmitWorkPo submitWorkPo) {
        this.submitWorkDao.insert(submitWorkPo);
        return submitWorkPo;
    }

    /**
     * 修改数据
     *
     * @param submitWorkPo 实例对象
     * @return 实例对象
     */
    @Override
    public SubmitWorkPo update(SubmitWorkPo submitWorkPo) {
        this.submitWorkDao.update(submitWorkPo);
        return this.getSubmitWorkById(submitWorkPo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.submitWorkDao.deleteById(id) > 0;
    }
}