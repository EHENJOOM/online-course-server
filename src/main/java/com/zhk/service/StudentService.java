package com.zhk.service;

import com.zhk.entity.po.StudentPo;

import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author 赵洪苛
 * @date 2020/08/01 11:01
 */
public interface StudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StudentPo getStudentById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<StudentPo> limit(int offset, int limit);

    /**
     * 查询记录总数
     *
     * @return 记录数
     */
    int count();

    /**
     * 新增数据
     *
     * @param studentPo 实例对象
     * @return 实例对象
     */
    StudentPo insert(StudentPo studentPo);

    /**
     * 修改数据
     *
     * @param studentPo 实例对象
     * @return 实例对象
     */
    StudentPo update(StudentPo studentPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}