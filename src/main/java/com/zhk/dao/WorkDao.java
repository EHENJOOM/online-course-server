package com.zhk.dao;

import com.zhk.entity.po.CoursePo;
import com.zhk.entity.po.WorkPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * (Work)表数据库访问层
 *
 * @author 赵洪苛
 * @date 2020-08-19 16:11:18
 */
public interface WorkDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from course.work where id = #{id}")
    @Results(id = "work", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR),
            @Result(property = "content", column = "content", jdbcType = JdbcType.VARCHAR),
            @Result(property = "permit", column = "permit", jdbcType = JdbcType.INTEGER),
            @Result(property = "publishTime", column = "publishTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "publish", column = "publish", jdbcType = JdbcType.INTEGER),
            @Result(property = "deadline", column = "deadline", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "coursePo", column = "courseId", javaType = CoursePo.class, one = @One(select = "com.zhk.dao.CourseDao.getCourseById", fetchType = FetchType.EAGER)),
    })
    WorkPo getWorkById(Integer id);

    /**
     * 通过TeacherId和courseId查询数据
     *
     * @param courseId 课程ID
     * @param teacherId 教师ID
     * @return 实例对象列表
     */
    @ResultMap("work")
    @Select("select * from course.work w, course.course c where w.courseId = #{courseId} and w.courseId = c.id and c.teacherId = #{teacherId}")
    List<WorkPo> getWorkByCourseAndTeacher(@Param("courseId") Integer courseId, @Param("teacherId") Integer teacherId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @ResultMap("work")
    @Select("select * from course.work limit #{offset}, #{limit}")
    List<WorkPo> limit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param workPo 实例对象
     * @return 对象列表
     */
    @ResultMap("work")
    @Select("select * from course.work")
    List<WorkPo> list(WorkPo workPo);

    /**
     * 查询记录总数
     *
     * @return 记录数
     */
    @Select("select count(*) from course.work")
    int count();

    /**
     * 新增数据
     *
     * @param workPo 实例对象
     * @return 影响行数
     */
    @Insert("insert into course.work(courseId, title, content, permit, publishTime, publish, deadline) values (#{coursePo.id}, #{title}, #{content}, #{permit}, #{publishTime}, #{publish}, #{deadline})")
    int insert(WorkPo workPo);

    /**
     * 修改数据
     *
     * @param workPo 实例对象
     * @return 影响行数
     */
    @Update("update course.work\n" +
            "        <set>\n" +
            "            <if test=\"coursePo != null and coursePo.id != null\">\n" +
            "                courseId = #{coursePo.id},\n" +
            "            </if>\n" +
            "            <if test=\"title != null and title != ''\">\n" +
            "                title = #{title},\n" +
            "            </if>\n" +
            "            <if test=\"content != null and content != ''\">\n" +
            "                content = #{content},\n" +
            "            </if>\n" +
            "            <if test=\"permit != null\">\n" +
            "                permit = #{permit},\n" +
            "            </if>\n" +
            "            <if test=\"publishTime != null\">\n" +
            "                publishTime = #{publishTime},\n" +
            "            </if>\n" +
            "            <if test=\"publish != null\">\n" +
            "                publish = #{publish},\n" +
            "            </if>\n" +
            "            <if test=\"deadline != null\">\n" +
            "                deadline = #{deadline},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        where id = #{id}")
    int update(WorkPo workPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from course.work where id = #{id}")
    int deleteById(Integer id);

}