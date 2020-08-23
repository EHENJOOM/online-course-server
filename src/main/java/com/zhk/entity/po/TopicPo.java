package com.zhk.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 * (Topic)实体类
 *
 * @author 赵洪苛
 * @since 2020-08-23 16:59:10
 */
public class TopicPo implements Serializable {
    private static final long serialVersionUID = 270046523801240413L;
    /**
     * 答疑讨论话题唯一ID
     */
    private Integer id;
    /**
     * 课程ID
     */
    private CoursePo coursePo;
    /**
     * 是否已发布
     */
    private Integer publish;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 话题内容
     */
    private String content;

    /**
     * 话题标题
     */
    private String title;

    /**
     * 已发布
     */
    public static int PUBLISHED = 1;

    /**
     * 未发布
     */
    public static int NOT_PUBLISH = 0;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CoursePo getCoursePo() {
        return coursePo;
    }

    public void setCoursePo(CoursePo coursePo) {
        this.coursePo = coursePo;
    }

    public Integer getPublish() {
        return publish;
    }

    public void setPublish(Integer publish) {
        this.publish = publish;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TopicPo{" +
                "id=" + id +
                ", coursePo=" + coursePo +
                ", publish=" + publish +
                ", publishTime=" + publishTime +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}