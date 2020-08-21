package com.zhk.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 * (Work)实体类
 *
 * @author 赵洪苛
 * @since 2020-08-19 16:11:18
 */
public class WorkPo implements Serializable {
    private static final long serialVersionUID = 158488494374749237L;
    /**
     * 作业唯一标识
     */
    private Integer id;
    /**
     * 作业标题
     */
    private String title;
    /**
     * 作业内容
     */
    private String content;
    /**
     * 允许提交次数
     */
    private Integer permit;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 是否已发布
     */
    private Integer publish;
    /**
     * 截止时间
     */
    private Date deadline;
    /**
     * 课程ID
     */
    private CoursePo coursePo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPermit() {
        return permit;
    }

    public void setPermit(Integer permit) {
        this.permit = permit;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getPublish() {
        return publish;
    }

    public void setPublish(Integer publish) {
        this.publish = publish;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public CoursePo getCoursePo() {
        return coursePo;
    }

    public void setCoursePo(CoursePo coursePo) {
        this.coursePo = coursePo;
    }

    @Override
    public String toString() {
        return "WorkPo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", permit=" + permit +
                ", publishTime=" + publishTime +
                ", publish=" + publish +
                ", deadline=" + deadline +
                ", coursePo=" + coursePo +
                '}';
    }
}