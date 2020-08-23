package com.zhk.dao;

import com.zhk.entity.po.CoursePo;
import com.zhk.entity.po.TeacherPo;
import com.zhk.entity.po.TopicPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * (Topic)表数据库访问层
 *
 * @author 赵洪苛
 * @date 2020-08-23 16:59:10
 */
public interface TopicDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from course.topic where id = #{id}")
    @Results(id = "topic", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "publish", column = "publish", jdbcType = JdbcType.INTEGER),
            @Result(property = "publishTime", column = "publish_time", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "content", column = "content", jdbcType = JdbcType.VARCHAR),
            @Result(property = "coursePo", column = "course_id", javaType = CoursePo.class, one = @One(select = "com.zhk.dao.CourseDao.getCourseById", fetchType = FetchType.EAGER)),
    })
    TopicPo getTopicById(Integer id);

    /**
     * 通过courseId查询数据
     *
     * @param courseId 课程ID
     * @return 对象列表
     */
    @ResultMap("topic")
    @Select("select * from course.topic where course_id = #{courseId}")
    List<TopicPo> getTopicByCourse(@Param("courseId") Integer courseId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @ResultMap("topic")
    @Select("select * from course.topic limit #{offset}, #{limit}")
    List<TopicPo> limit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param topicPo 实例对象
     * @return 对象列表
     */
    @ResultMap("topic")
    @Select("select * from course.topic")
    List<TopicPo> list(TopicPo topicPo);

    /**
     * 新增数据
     *
     * @param topicPo 实例对象
     * @return 影响行数
     */
    @Insert("insert into course.topic(course_id, publish, publish_time, content, title) " +
            "values (#{coursePo.id}, #{publish}, #{publishTime}, #{content}, #{title})")
    int insert(TopicPo topicPo);

    /**
     * 修改数据
     *
     * @param topicPo 实例对象
     * @return 影响行数
     */
    @Update("<script>update course.topic\n" +
            "        <set>\n" +
            "            <if test=\"coursePo != null and coursePo.id > 0\">\n" +
            "                course_id = #{coursePo.id},\n" +
            "            </if>\n" +
            "            <if test=\"publish != null\">\n" +
            "                publish = #{publish},\n" +
            "            </if>\n" +
            "            <if test=\"publishTime != null\">\n" +
            "                publish_time = #{publishTime},\n" +
            "            </if>\n" +
            "            <if test=\"content != null and content != ''\">\n" +
            "                content = #{content},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        where id = #{id}</script>")
    int update(TopicPo topicPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from course.topic where id = #{id}")
    int deleteById(Integer id);

}