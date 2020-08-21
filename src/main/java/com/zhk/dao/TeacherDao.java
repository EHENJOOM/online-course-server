package com.zhk.dao;

import com.zhk.entity.po.TeacherPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * (Teacher)表数据库访问层
 *
 * @author 赵洪苛
 * @date 2020/08/01 11:01
 */
@Mapper
public interface TeacherDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select id, number, name, avatar, birth, sex, password " +
            "from course.teacher where id = #{id}")
    @Results(id = "teacher", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "number", column = "number", jdbcType = JdbcType.VARCHAR),
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "avatar", column = "avatar", jdbcType = JdbcType.VARCHAR),
            @Result(property = "birth", column = "birth", jdbcType = JdbcType.DATE),
            @Result(property = "sex", column = "sex", jdbcType = JdbcType.VARCHAR),
            @Result(property = "password", column = "password", jdbcType = JdbcType.VARCHAR),
    })
    TeacherPo getTeacherById(Integer id);

    /**
     * 通过工号查询单条数据
     *
     * @param number 工号
     * @return 实例对象
     */
    @Select("select id, number, name, avatar, birth, sex, password " +
            "from course.teacher where number = #{number}")
    TeacherPo getTeacherByNumber(String number);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select id, number, name, avatar, birth, sex, password\n" +
            "    from course.teacher limit #{offset}, #{limit}")
    List<TeacherPo> limit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 查询所有记录
     *
     * @return 对象列表
     */
    @Select("select id, number, name, avatar, birth, sex, password\n" +
            "    from course.teacher")
    List<TeacherPo> list();

    /**
     * 查询记录总数
     *
     * @return 记录数
     */
    @Select("select count(*) from course.teacher")
    int count();

    /**
     * 新增数据
     *
     * @param teacherPo 实例对象
     * @return 影响行数
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into course.teacher(number, name, avatar, birth, sex, password)\n" +
            "    values (#{number}, #{name}, #{avatar}, #{birth}, #{sex}, #{password})")
    int insert(TeacherPo teacherPo);

    /**
     * 修改数据
     *
     * @param teacherPo 实例对象
     * @return 影响行数
     */
    @Update("update course.teacher\n" +
            "        <set>\n" +
            "            <if test=\"name != null and name != ''\">\n" +
            "                name = #{name},\n" +
            "            </if>\n" +
            "            <if test=\"avatar != null and avatar != ''\">\n" +
            "                avatar = #{avatar},\n" +
            "            </if>\n" +
            "            <if test=\"birth != null\">\n" +
            "                birth = #{birth},\n" +
            "            </if>\n" +
            "            <if test=\"sex != null and sex != ''\">\n" +
            "                sex = #{sex},\n" +
            "            </if>\n" +
            "            <if test=\"password != null and password != ''\">\n" +
            "                password = #{password},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        where id = #{id}")
    int update(TeacherPo teacherPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from course.teacher where id = #{id}")
    int deleteById(Integer id);

}