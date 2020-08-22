package com.zhk.service.impl;

import com.zhk.dao.WorkDao;
import com.zhk.entity.po.WorkPo;
import com.zhk.service.WorkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Work)表服务实现类
 *
 * @author 赵洪苛
 * @date 2020-08-19 16:11:18
 */
@Service("workService")
public class WorkServiceImpl implements WorkService {
    @Resource
    private WorkDao workDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public WorkPo getWorkById(Integer id) {
        return this.workDao.getWorkById(id);
    }

    /**
     * 通过TeacherId和courseId查询数据
     *
     * @param courseId 课程ID
     * @param teacherId 教师ID
     * @return 实例对象列表
     */
    @Override
    public List<WorkPo> getWorkByCourseAndTeacher(Integer courseId, Integer teacherId) {
        return this.workDao.getWorkByCourseAndTeacher(courseId, teacherId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<WorkPo> limit(int offset, int limit) {
        return this.workDao.limit(offset, limit);
    }

    /**
     * 通过teacherId查询指定行数据
     *
     * @param courseId 课程ID
     * @param teacherId 教师ID
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<WorkPo> limitByTeacherId(Integer courseId, Integer teacherId, int offset, int limit) {
        return this.workDao.limitByTeacherId(courseId, teacherId, offset, limit);
    }

    /**
     * 查询记录总数
     *
     * @return 记录数
     */
    @Override
    public int count() {
        return this.workDao.count();
    }

    /**
     * 新增数据
     *
     * @param workPo 实例对象
     * @return 实例对象
     */
    @Override
    public WorkPo insert(WorkPo workPo) {
        this.workDao.insert(workPo);
        return workPo;
    }

    /**
     * 修改数据
     *
     * @param workPo 实例对象
     * @return 实例对象
     */
    @Override
    public WorkPo update(WorkPo workPo) {
        this.workDao.update(workPo);
        return this.getWorkById(workPo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.workDao.deleteById(id) > 0;
    }
}