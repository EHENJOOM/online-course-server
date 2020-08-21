package com.zhk.dao;

import com.zhk.entity.po.CoursePo;
import com.zhk.entity.po.StudentPo;
import com.zhk.entity.po.SubmitWorkPo;
import com.zhk.entity.po.WorkPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * (SubmitWork)表数据库访问层
 *
 * @author 赵洪苛
 * @date 2020-08-19 16:11:14
 */
public interface SubmitWorkDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from course.submit_work where id = #{id}")
    @Results(id = "submitWork", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "submit", column = "submit", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "status", column = "status", jdbcType = JdbcType.INTEGER),
            @Result(property = "path", column = "path", jdbcType = JdbcType.VARCHAR),
            @Result(property = "score", column = "score", jdbcType = JdbcType.DOUBLE),
            @Result(property = "workPo", column = "workId", javaType = WorkPo.class, one = @One(select = "com.zhk.dao.WorkDao.getWorkById", fetchType = FetchType.EAGER)),
            @Result(property = "studentPo", column = "studentId", javaType = StudentPo.class, one = @One(select = "com.zhk.dao.StudentDao.getStudentById", fetchType = FetchType.EAGER))
    })
    SubmitWorkPo getSubmitWorkById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @ResultMap("submitWork")
    @Select("select * from course.submit_work limit #{offset}, #{limit}")
    List<SubmitWorkPo> limit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过workId查询提交的数据实例
     *
     * @param workId WorkPo主键
     * @return 对象列表
     */
    @ResultMap("submitWork")
    @Select("select * from course.submit_work where workId = #{workId}")
    List<SubmitWorkPo> getSubmitWorkByWorkId(@Param("workId") Integer workId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param submitWorkPo 实例对象
     * @return 对象列表
     */
    @ResultMap("submitWork")
    @Select("select * from course.submit_work")
    List<SubmitWorkPo> list(SubmitWorkPo submitWorkPo);

    /**
     * 新增数据
     *
     * @param submitWorkPo 实例对象
     * @return 影响行数
     */
    @Insert("insert into course.submit_work(workId, studentId, submit, status, path, score) " +
            "values (#{workPo.id}, #{studentPo.id}, #{submit}, #{status}, #{path}, #{score})")
    int insert(SubmitWorkPo submitWorkPo);

    /**
     * 修改数据
     *
     * @param submitWorkPo 实例对象
     * @return 影响行数
     */
    @Update("<script>update course.submit_work\n" +
            "        <set>\n" +
            "            <if test=\"workPo != null and workPo.id != null\">\n" +
            "                workId = #{workPo.id},\n" +
            "            </if>\n" +
            "            <if test=\"studentPo != null and studentPo.id != null\">\n" +
            "                studentId = #{studentPo.id},\n" +
            "            </if>\n" +
            "            <if test=\"submit != null\">\n" +
            "                submit = #{submit},\n" +
            "            </if>\n" +
            "            <if test=\"status != null\">\n" +
            "                status = #{status},\n" +
            "            </if>\n" +
            "            <if test=\"path != null and path != ''\">\n" +
            "                path = #{path},\n" +
            "            </if>\n" +
            "            <if test=\"score != null\">\n" +
            "                score = #{score},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        where id = #{id}</script>")
    int update(SubmitWorkPo submitWorkPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from course.submit_work where id = #{id}")
    int deleteById(Integer id);

}