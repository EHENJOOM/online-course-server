package com.zhk.dao;

import com.zhk.entity.po.OfficerPo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Officer)表数据库访问层
 *
 * @author 赵洪苛
 * @date 2020-08-24 21:30:26
 */
public interface OfficerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select id, name, avatar, number, password, academy, sex from course.officer where id = #{id}")
    OfficerPo getOfficerById(Integer id);

    /**
     * 通过工号查询单条数据
     *
     * @param number 工号
     * @return 单条数据
     */
    @Select("select id, name, avatar, number, password, academy, sex from course.officer where number = #{number}")
    OfficerPo getOfficerByNumber(String number);

    /**
     * 统计院教务员数
     *
     * @return 总数
     */
    @Select("select count(*) from course.officer")
    int count();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select id, name, avatar, number, password, academy, sex from course.officer limit #{offset}, #{limit}")
    List<OfficerPo> limit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param officerPo 实例对象
     * @return 对象列表
     */
    @Select("select id, name, avatar, number, password, academy, sex from course.officer")
    List<OfficerPo> list(OfficerPo officerPo);

    /**
     * 新增数据
     *
     * @param officerPo 实例对象
     * @return 影响行数
     */
    @Insert("insert into course.officer(name, avatar, number, password, academy, sex) " +
            "values (#{name}, #{avatar}, #{number}, #{password}, #{academy}, #{sex})")
    int insert(OfficerPo officerPo);

    /**
     * 修改数据
     *
     * @param officerPo 实例对象
     * @return 影响行数
     */
    @Update("<script>update course.officer\n" +
            "        <set>\n" +
            "            <if test=\"name != null and name != ''\">\n" +
            "                name = #{name},\n" +
            "            </if>\n" +
            "            <if test=\"avatar != null and avatar != ''\">\n" +
            "                avatar = #{avatar},\n" +
            "            </if>\n" +
            "            <if test=\"number != null and number != ''\">\n" +
            "                number = #{number},\n" +
            "            </if>\n" +
            "            <if test=\"password != null and password != ''\">\n" +
            "                password = #{password},\n" +
            "            </if>\n" +
            "            <if test=\"academy != null and academy != ''\">\n" +
            "                academy = #{academy},\n" +
            "            </if>\n" +
            "            <if test=\"sex != null and sex != ''\">\n" +
            "                sex = #{sex},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        where id = #{id}</script>")
    int update(OfficerPo officerPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from course.officer where id = #{id}")
    int deleteById(Integer id);

}