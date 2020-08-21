package com.zhk.dao;

import com.zhk.entity.po.AdminClazzPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * (AdminClazz)表数据库访问层
 *
 * @author 赵洪苛
 * @date 2020-08-17 19:39:31
 */
public interface AdminClazzDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select id, code, name, academy, grade, count from course.adminclazz where id = #{id}")
    @Results(id = "adminClazz", value = {
            @Result(property="id", column="id", id = true),
            @Result(property="code", column="code", jdbcType = JdbcType.VARCHAR),
            @Result(property="name", column="name", jdbcType = JdbcType.VARCHAR),
            @Result(property="academy", column="academy", jdbcType = JdbcType.VARCHAR),
            @Result(property="grade", column="grade", jdbcType = JdbcType.VARCHAR),
            @Result(property="count", column="count", jdbcType = JdbcType.INTEGER),
    })
    AdminClazzPo getAdminClazzById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select id, code, name, academy, grade, count from course.adminclazz limit #{offset}, #{limit}")
    @ResultMap("adminClazz")
    List<AdminClazzPo> limit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    @Select("select id, code, name, academy, grade, count from course.adminclazz")
    @ResultMap("adminClazz")
    List<AdminClazzPo> list();

    @Select("<script>select id, code, name, academy, grade, count from course.adminclazz\n" +
            "        <where>\n" +
            "            <if test='id != null'>\n" +
            "                and id = #{id}\n" +
            "            </if>\n" +
            "            <if test=\"code != null and code != ''\">\n" +
            "                and code = #{code}\n" +
            "            </if>\n" +
            "            <if test=\"name != null and name != ''\">\n" +
            "                and name = #{name}\n" +
            "            </if>\n" +
            "            <if test=\"academy != null and academy != ''\">\n" +
            "                and academy = #{academy}\n" +
            "            </if>\n" +
            "            <if test=\"grade != null and grade != ''\">\n" +
            "                and grade = #{grade}\n" +
            "            </if>\n" +
            "            <if test=\"count != null\">\n" +
            "                and count = #{count}\n" +
            "            </if>\n" +
            "        </where></script>")
    @ResultMap("adminClazz")
    List<AdminClazzPo> getAdminClazz(AdminClazzPo adminClazzPo);

    /**
     * 新增数据
     *
     * @param adminClazzPo 实例对象
     * @return 影响行数
     */
    @Insert("insert into course.adminclazz(code, name, academy, grade, count) values (#{code}, #{name}, #{academy}, #{grade}, #{count})")
    @ResultMap("adminClazz")
    int insert(AdminClazzPo adminClazzPo);

    /**
     * 修改数据
     *
     * @param adminClazzPo 实例对象
     * @return 影响行数
     */
    @Update("<script>update course.adminclazz\n" +
            "        <set>\n" +
            "            <if test=\"code != null and code != ''\">\n" +
            "                code = #{code},\n" +
            "            </if>\n" +
            "            <if test=\"name != null and name != ''\">\n" +
            "                name = #{name},\n" +
            "            </if>\n" +
            "            <if test=\"academy != null and academy != ''\">\n" +
            "                academy = #{academy},\n" +
            "            </if>\n" +
            "            <if test=\"grade != null and grade != ''\">\n" +
            "                grade = #{grade},\n" +
            "            </if>\n" +
            "            <if test=\"count != null\">\n" +
            "                count = #{count},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        where id = #{id}</script>")
    @ResultMap("adminClazz")
    int update(AdminClazzPo adminClazzPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from course.adminclazz where id = #{id}")
    @ResultMap("adminClazz")
    int deleteById(Integer id);

}