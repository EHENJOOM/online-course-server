package com.zhk.dao;

import com.zhk.entity.po.AdminPo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author 赵洪苛
 * @date 2020-08-24 21:30:22
 */
public interface AdminDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select id, number, password, name, sex, avatar from course.admin where id = #{id}")
    AdminPo getAdminById(Integer id);

    /**
     * 通过工号查询单条数据
     *
     * @param number 工号
     * @return 实例对象
     */
    @Select("select id, number, password, name, sex, avatar from course.admin where number = #{number}")
    AdminPo getAdminByNumber(String number);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select id, number, password, name, sex, avatar from course.admin limit #{offset}, #{limit}")
    List<AdminPo> limit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询系统管理员数量
     *
     * @return 总数
     */
    @Select("select count(*) from course.admin")
    int count();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param adminPo 实例对象
     * @return 对象列表
     */
    @Select("select id, number, password, name, sex, avatar from course.admin")
    List<AdminPo> list(AdminPo adminPo);

    /**
     * 新增数据
     *
     * @param adminPo 实例对象
     * @return 影响行数
     */
    @Insert("insert into course.admin(number, password, name, sex, avatar) values (#{number}, #{password}, #{name}, #{sex}, #{avatar})")
    int insert(AdminPo adminPo);

    /**
     * 修改数据
     *
     * @param adminPo 实例对象
     * @return 影响行数
     */
    @Update("<script>update course.admin\n" +
            "        <set>\n" +
            "            <if test=\"number != null and number != ''\">\n" +
            "                number = #{number},\n" +
            "            </if>\n" +
            "            <if test=\"password != null and password != ''\">\n" +
            "                password = #{password},\n" +
            "            </if>\n" +
            "            <if test=\"name != null and name != ''\">\n" +
            "                name = #{name},\n" +
            "            </if>\n" +
            "            <if test=\"sex != null and sex != ''\">\n" +
            "                sex = #{sex},\n" +
            "            </if>\n" +
            "            <if test=\"avatar != null and avatar != ''\">\n" +
            "                avatar = #{avatar},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        where id = #{id}</script>")
    int update(AdminPo adminPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from course.admin where id = #{id}")
    int deleteById(Integer id);

}