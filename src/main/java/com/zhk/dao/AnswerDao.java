package com.zhk.dao;

import com.zhk.entity.po.AnswerPo;
import com.zhk.entity.po.CoursePo;
import com.zhk.entity.po.TopicPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * (Answer)表数据库访问层
 *
 * @author 赵洪苛
 * @date 2020-08-23 16:59:08
 */
public interface AnswerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from course.answer where id = #{id}")
    @Results(id = "answer", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "number", column = "number", jdbcType = JdbcType.VARCHAR),
            @Result(property = "avatar", column = "avatar", jdbcType = JdbcType.VARCHAR),
            @Result(property = "publishTime", column = "publish_time", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "content", column = "content", jdbcType = JdbcType.VARCHAR),
            @Result(property = "topicPo", column = "topic_id", javaType = TopicPo.class, one = @One(select = "com.zhk.dao.TopicDao.getTopicById", fetchType = FetchType.EAGER)),
    })
    AnswerPo getAnswerById(Integer id);

    /**
     * 通过topicId查询答疑信息
     *
     * @param topicId 主题ID
     * @return 对象列表
     */
    @ResultMap("answer")
    @Select("select * from course.answer where topic_id = #{topicId}")
    List<AnswerPo> getAnswerByTopic(@Param("topicId") Integer topicId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @ResultMap("answer")
    @Select("select * from course.answer limit #{offset}, #{limit}")
    List<AnswerPo> limit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param answerPo 实例对象
     * @return 对象列表
     */
    @ResultMap("answer")
    @Select("select * from course.answer")
    List<AnswerPo> list(AnswerPo answerPo);

    /**
     * 新增数据
     *
     * @param answerPo 实例对象
     * @return 影响行数
     */
    @Insert("insert into course.answer(number, name, avatar, publish_time, content, topic_id) " +
            "values (#{number}, #{name}, #{avatar}, #{publishTime}, #{content}, #{topicPo.id})")
    int insert(AnswerPo answerPo);

    /**
     * 修改数据
     *
     * @param answerPo 实例对象
     * @return 影响行数
     */
    @Update("<script>update course.answer\n" +
            "        <set>\n" +
            "            <if test=\"number != null and number != ''\">\n" +
            "                number = #{number},\n" +
            "            </if>\n" +
            "            <if test=\"name != null and name != ''\">\n" +
            "                name = #{name},\n" +
            "            </if>\n" +
            "            <if test=\"avatar != null and avatar != ''\">\n" +
            "                avatar = #{avatar},\n" +
            "            </if>\n" +
            "            <if test=\"publishTime != null\">\n" +
            "                publish_time = #{publishTime},\n" +
            "            </if>\n" +
            "            <if test=\"content != null and content != ''\">\n" +
            "                content = #{content},\n" +
            "            </if>\n" +
            "            <if test=\"topicPo != null and topicPo.id > 0\">\n" +
            "                topic_id = #{topicPo.id},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        where id = #{id}</script>")
    int update(AnswerPo answerPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from course.answer where id = #{id}")
    int deleteById(Integer id);

}