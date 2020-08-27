package com.zhk.service.impl;

import com.zhk.dao.CourseDao;
import com.zhk.entity.po.CoursePo;
import com.zhk.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Course)表服务实现类
 *
 * @author 赵洪苛
 * @date 2020-08-08 20:43:00
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseDao courseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CoursePo getCourseById(Integer id) {
        return this.courseDao.getCourseById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CoursePo> limit(int offset, int limit) {
        return this.courseDao.limit(offset, limit);
    }

    /**
     * 根据学院查询指定行数
     *
     * @param academy 学院
     * @param offset  查询起始位置
     * @param limit   查询条数
     * @return 对象列表
     */
    @Override
    public List<CoursePo> limitByAcademy(String academy, int offset, int limit) {
        return this.courseDao.limitByAcademy(academy, offset, limit);
    }

    /**
     * 通过学院名查询记录数
     *
     * @param academy 学院名
     * @return 记录数
     */
    @Override
    public Integer countByAcademy(String academy) {
        return this.courseDao.countByAcademy(academy);
    }

    /**
     * 根据教师ID查询对应的课程
     *
     * @param id 教师ID
     * @return 课程
     */
    @Override
    public List<CoursePo> getCourseByTeacherId(Integer id) {
        return this.courseDao.getCourseByTeacherId(id);
    }

    /**
     * 查询记录总数
     *
     * @return 记录数
     */
    @Override
    public int count() {
        return this.courseDao.count();
    }

    /**
     * 新增数据
     *
     * @param coursePo 实例对象
     * @return 实例对象
     */
    @Override
    public CoursePo insert(CoursePo coursePo) {
        this.courseDao.insert(coursePo);
        return coursePo;
    }

    /**
     * 修改数据
     *
     * @param coursePo 实例对象
     * @return 实例对象
     */
    @Override
    public CoursePo update(CoursePo coursePo) {
        this.courseDao.update(coursePo);
        return this.getCourseById(coursePo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.courseDao.deleteById(id) > 0;
    }
}