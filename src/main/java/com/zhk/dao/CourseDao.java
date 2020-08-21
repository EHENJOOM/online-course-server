package com.zhk.dao;

import com.zhk.entity.po.CoursePo;
import com.zhk.entity.po.TeacherPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * (Course)表数据库访问层
 *
 * @author 赵洪苛
 * @date 2020-08-08 20:43:00
 */
public interface CourseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from course.course c where c.id = #{id}")
    @Results(id = "course", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "description", column = "description", jdbcType = JdbcType.INTEGER),
            @Result(property = "outline", column = "outline", jdbcType = JdbcType.VARCHAR),
            @Result(property = "calendar", column = "calendar", jdbcType = JdbcType.VARCHAR),
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "code", column = "code", jdbcType = JdbcType.VARCHAR),
            @Result(property = "img", column = "img", jdbcType = JdbcType.VARCHAR),
            @Result(property = "teacherPo", column = "teacherId", javaType = TeacherPo.class, one = @One(select = "com.zhk.dao.TeacherDao.getTeacherById", fetchType = FetchType.EAGER))
    })
    CoursePo getCourseById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select * from course.course limit #{offset}, #{limit}")
    @ResultMap("course")
    List<CoursePo> limit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param coursePo 实例对象
     * @return 对象列表
     */
    @Select("select * from course.course")
    @ResultMap("course")
    List<CoursePo> list(CoursePo coursePo);

    /**
     * 根据教师ID查询对应的课程
     *
     * @param id 教师ID
     * @return 课程
     */
    @Select("select * from course.course c where c.teacherId = #{id}")
    @ResultMap("course")
    List<CoursePo> getCourseByTeacherId(Integer id);

    /**
     * 查询记录总数
     *
     * @return 记录数
     */
    @Select("select count(*) from course.course")
    int count();

    /**
     * 新增数据
     *
     * @param coursePo 实例对象
     * @return 影响行数
     */
    @Insert("insert into course.course(description, outline, calendar, name, code, img, teacherId)\n" +
            "values (#{description}, #{outline}, #{calendar}, #{name}, #{code}, #{img}, #{teacherPo.id})")
    int insert(CoursePo coursePo);

    /**
     * 修改数据
     *
     * @param coursePo 实例对象
     * @return 影响行数
     */
    @Update("<script>update course.course\n" +
            "        <set>\n" +
            "            <if test=\"description != null and description != ''\">\n" +
            "                description = #{description},\n" +
            "            </if>\n" +
            "            <if test=\"outline != null and outline != ''\">\n" +
            "                outline = #{outline},\n" +
            "            </if>\n" +
            "            <if test=\"calendar != null and calendar != ''\">\n" +
            "                calendar = #{calendar},\n" +
            "            </if>\n" +
            "            <if test=\"name != null and name != ''\">\n" +
            "                name = #{name},\n" +
            "            </if>\n" +
            "            <if test=\"code != null and code != ''\">\n" +
            "                code = #{code},\n" +
            "            </if>\n" +
            "            <if test=\"img != null and img != ''\">\n" +
            "                img = #{img},\n" +
            "            </if>\n" +
            "            <if test=\"teacherPo != null and teacherPo.id != null\">\n" +
            "                teacherId = #{teacherPo.id},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        where id = #{id}</script>")
    int update(CoursePo coursePo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from course.course where id = #{id}")
    int deleteById(Integer id);

}