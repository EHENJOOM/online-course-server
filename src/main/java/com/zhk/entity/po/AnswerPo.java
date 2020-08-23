package com.zhk.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 * (Answer)实体类
 *
 * @author 赵洪苛
 * @since 2020-08-23 16:59:07
 */
public class AnswerPo implements Serializable {
    private static final long serialVersionUID = -96493728500406457L;
    /**
     * 答疑讨论消息唯一ID
     */
    private Integer id;
    /**
     * 学号或工号
     */
    private String number;
    /**
     * 姓名
     */
    private String name;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 发表时间
     */
    private Date publishTime;
    /**
     * 内容
     */
    private String content;
    /**
     * 话题ID
     */
    private TopicPo topicPo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public TopicPo getTopicPo() {
        return topicPo;
    }

    public void setTopicPo(TopicPo topicPo) {
        this.topicPo = topicPo;
    }

    @Override
    public String toString() {
        return "AnswerPo{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", publishTime=" + publishTime +
                ", content='" + content + '\'' +
                ", topicPo=" + topicPo +
                '}';
    }
}