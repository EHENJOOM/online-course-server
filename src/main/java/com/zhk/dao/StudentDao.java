package com.zhk.dao;

import com.zhk.entity.po.StudentPo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Student)表数据库访问层
 *
 * @author 赵洪苛
 * @date 2020/08/01 11:01
 */
@Mapper
public interface StudentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select\n" +
            "    id, number, name, avatar, birth, sex, password, academy, major, grade, clazz\n" +
            "    from course.student\n" +
            "    where id = #{id}")
    StudentPo getStudentById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select\n" +
            "    id, number, name, avatar, birth, sex, password, academy, major, grade, clazz\n" +
            "    from course.student\n" +
            "    limit #{offset}, #{limit}")
    List<StudentPo> limit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 查询所有记录
     *
     * @return 对象列表
     */
    @Select("select\n" +
            "    id, number, name, avatar, birth, sex, password, academy, major, grade, clazz\n" +
            "    from course.student")
    List<StudentPo> list();

    /**
     * 查询记录总数
     *
     * @return 记录数
     */
    @Select("select count(*) from course.student")
    int count();

    /**
     * 新增数据
     *
     * @param studentPo 实例对象
     * @return 影响行数
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into course.student(number, name, avatar, birth, sex, password, academy, major, grade, clazz)\n" +
            "    values (#{number}, #{name}, #{avatar}, #{birth}, #{sex}, #{password}, #{academy}, #{major}, #{grade}, #{clazz})")
    int insert(StudentPo studentPo);

    /**
     * 修改数据
     *
     * @param studentPo 实例对象
     * @return 影响行数
     */
    @Update("<script>update course.student\n" +
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
            "            <if test=\"academy != null and academy != ''\">\n" +
            "                academy = #{academy},\n" +
            "            </if>\n" +
            "            <if test=\"major != null and major != ''\">\n" +
            "                major = #{major},\n" +
            "            </if>\n" +
            "            <if test=\"grade != null and grade != ''\">\n" +
            "                grade = #{grade},\n" +
            "            </if>\n" +
            "            <if test=\"clazz != null and clazz != ''\">\n" +
            "                clazz = #{clazz},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        where id = #{id}</script>")
    int update(StudentPo studentPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from course.student where id = #{id}")
    int deleteById(Integer id);

}