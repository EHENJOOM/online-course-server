package com.zhk.service;

import com.zhk.entity.po.TeacherPo;

import java.util.List;

/**
 * (Teacher)表服务接口
 *
 * @author 赵洪苛
 * @date 2020/08/01 11:01
 */
public interface TeacherService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TeacherPo getTeacherById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TeacherPo> limit(int offset, int limit);

    /**
     * 查询记录总数
     *
     * @return 记录数
     */
    int count();

    /**
     * 新增数据
     *
     * @param teacherPo 实例对象
     * @return 实例对象
     */
    TeacherPo insert(TeacherPo teacherPo);

    /**
     * 修改数据
     *
     * @param teacherPo 实例对象
     * @return 实例对象
     */
    TeacherPo update(TeacherPo teacherPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}