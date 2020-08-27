package com.zhk.service;

import com.zhk.entity.po.CoursePo;

import java.util.List;

/**
 * (Course)表服务接口
 *
 * @author 赵洪苛
 * @date 2020-08-08 20:43:00
 */
public interface CourseService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CoursePo getCourseById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CoursePo> limit(int offset, int limit);

    /**
     * 根据学院查询指定行数
     *
     * @param academy 学院
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CoursePo> limitByAcademy(String academy, int offset, int limit);

    /**
     * 通过学院名查询记录数
     *
     * @param academy 学院名
     * @return 记录数
     */
    Integer countByAcademy(String academy);

    /**
     * 根据教师ID查询对应的课程
     *
     * @param id 教师ID
     * @return 课程
     */
    List<CoursePo> getCourseByTeacherId(Integer id);

    /**
     * 查询记录总数
     *
     * @return 记录数
     */
    int count();

    /**
     * 新增数据
     *
     * @param coursePo 实例对象
     * @return 实例对象
     */
    CoursePo insert(CoursePo coursePo);

    /**
     * 修改数据
     *
     * @param coursePo 实例对象
     * @return 实例对象
     */
    CoursePo update(CoursePo coursePo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}