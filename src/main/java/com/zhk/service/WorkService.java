package com.zhk.service;

import com.zhk.entity.po.WorkPo;

import java.util.List;

/**
 * (Work)表服务接口
 *
 * @author 赵洪苛
 * @date 2020-08-19 16:11:18
 */
public interface WorkService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WorkPo getWorkById(Integer id);

    /**
     * 通过TeacherId和courseId查询数据
     *
     * @param courseId 课程ID
     * @param teacherId 教师ID
     * @return 实例对象列表
     */
    List<WorkPo> getWorkByCourseAndTeacher(Integer courseId, Integer teacherId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<WorkPo> limit(int offset, int limit);

    /**
     * 查询记录总数
     *
     * @return 记录数
     */
    int count();

    /**
     * 新增数据
     *
     * @param workPo 实例对象
     * @return 实例对象
     */
    WorkPo insert(WorkPo workPo);

    /**
     * 修改数据
     *
     * @param workPo 实例对象
     * @return 实例对象
     */
    WorkPo update(WorkPo workPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}