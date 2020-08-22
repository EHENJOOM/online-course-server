package com.zhk.dao;

import com.zhk.entity.po.FilePo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * (File)表数据库访问层
 *
 * @author 赵洪苛
 * @date 2020-08-22 21:23:41
 */
public interface FileDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select id, logical_name, minio_name, url, teacher_id, course_id from course.file where id = #{id}")
    @Results(id = "file", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "logicalName", column = "logical_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "minioName", column = "minio_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "teacherId", column = "teacher_id", jdbcType = JdbcType.INTEGER),
            @Result(property = "courseId", column = "course_id", jdbcType = JdbcType.INTEGER),
    })
    FilePo getFileById(Integer id);

    /**
     * 通过courseId和teacherId查询文件信息
     *
     * @param courseId 课程ID
     * @param teacherId 教师ID
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 实例对象列表
     */
    @ResultMap("file")
    @Select("select id, logical_name, minio_name, url, teacher_id, course_id from course.file where teacher_id = #{teacherId} and course_id = #{courseId} limit #{offset}, #{limit}")
    List<FilePo> getFileByCourseAndTeacher(@Param("courseId") Integer courseId, @Param("teacherId") Integer teacherId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 计算courseId和teacherId对应的总文件数
     *
     * @param courseId 课程ID
     * @param teacherId 教师ID
     * @return 记录数
     */
    @ResultMap("file")
    @Select("select count(*) from course.file where teacher_id = #{teacherId} and course_id = #{courseId}")
    Integer countByCourseAndTeacher(@Param("courseId") Integer courseId, @Param("teacherId") Integer teacherId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @ResultMap("file")
    @Select("select id, logical_name, minio_name, url, teacher_id, course_id from course.file limit #{offset}, #{limit}")
    List<FilePo> limit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param filePo 实例对象
     * @return 对象列表
     */
    @ResultMap("file")
    @Select("select id, logical_name, minio_name, url, teacher_id, course_id from course.file")
    List<FilePo> list(FilePo filePo);

    /**
     * 新增数据
     *
     * @param filePo 实例对象
     * @return 影响行数
     */
    @Insert("insert into course.file(logical_name, minio_name, url, teacher_id, course_id) " +
            "values (#{logicalName}, #{minioName}, #{url}, #{teacherId}, #{courseId})")
    int insert(FilePo filePo);

    /**
     * 修改数据
     *
     * @param filePo 实例对象
     * @return 影响行数
     */
    @Update("<script>update course.file\n" +
            "        <set>\n" +
            "            <if test=\"logicalName != null and logicalName != ''\">\n" +
            "                logical_name = #{logicalName},\n" +
            "            </if>\n" +
            "            <if test=\"minioName != null and minioName != ''\">\n" +
            "                minio_name = #{minioName},\n" +
            "            </if>\n" +
            "            <if test=\"url != null and url != ''\">\n" +
            "                url = #{url},\n" +
            "            </if>\n" +
            "            <if test=\"teacherId != null\">\n" +
            "                teacher_id = #{teacherId},\n" +
            "            </if>\n" +
            "            <if test=\"courseId != null\">\n" +
            "                course_id = #{courseId},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        where id = #{id}</script>")
    int update(FilePo filePo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from course.file where id = #{id}")
    int deleteById(Integer id);

}