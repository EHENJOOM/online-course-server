package com.zhk.dao;

import com.zhk.entity.po.ClazzPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * (Clazz)表数据库访问层
 *
 * @author 赵洪苛
 * @date 2020-08-18 17:16:16
 */
public interface ClazzDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select id, studentId, courseId from course.clazz where id = #{id}")
    @Results(id = "clazz", value = {
            @Result(property="id", column="id", id = true),
            @Result(property="studentId", column="studentId", jdbcType = JdbcType.INTEGER),
            @Result(property="courseId", column="courseId", jdbcType = JdbcType.INTEGER),
    })
    ClazzPo getClazzById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @ResultMap("clazz")
    @Select("select id, studentId, courseId from course.clazz limit #{offset}, #{limit}")
    List<ClazzPo> limit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param clazzPo 实例对象
     * @return 对象列表
     */
    @ResultMap("clazz")
    @Select("select id, studentId, courseId from course.clazz")
    List<ClazzPo> list(ClazzPo clazzPo);

    /**
     * 新增数据
     *
     * @param clazzPo 实例对象
     * @return 影响行数
     */
    @ResultMap("clazz")
    @Insert("insert into course.clazz(studentId, courseId) values (#{studentId}, #{courseId})")
    int insert(ClazzPo clazzPo);

    /**
     * 批量新增数据
     *
     * @param clazzPoList 实例对象列表
     * @return 影响行数
     */
    @Insert("<script>insert into course.clazz(studentId, courseId) values\n" +
            "        <foreach collection='list' item='item' index='index' separator=','>\n" +
            "            (#{item.studentId}, #{item.courseId})\n" +
            "        </foreach></script>")
    @ResultMap("clazz")
    int insertClazzList(List<ClazzPo> clazzPoList);

    /**
     * 修改数据
     *
     * @param clazzPo 实例对象
     * @return 影响行数
     */
    @Update("<script>update course.clazz\n" +
            "        <set>\n" +
            "            <if test=\"studentId != null\">\n" +
            "                studentId = #{studentId},\n" +
            "            </if>\n" +
            "            <if test=\"courseId != null\">\n" +
            "                courseId = #{courseId},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        where id = #{id}</script>")
    @ResultMap("clazz")
    int update(ClazzPo clazzPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @ResultMap("clazz")
    @Delete("delete from course.clazz where id = #{id}")
    int deleteById(Integer id);

}