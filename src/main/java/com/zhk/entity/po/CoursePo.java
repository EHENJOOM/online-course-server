package com.zhk.entity.po;

import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author 赵洪苛
 * @since 2020-08-08 20:42:59
 */
public class CoursePo implements Serializable {
    private static final long serialVersionUID = 632529041770379289L;
    /**
     * 课程唯一标识
     */
    private Integer id;
    /**
     * 课程介绍
     */
    private String description;
    /**
     * 教学大纲
     */
    private String outline;
    /**
     * 教学日历
     */
    private String calendar;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 课程代码
     */
    private String code;
    /**
     * 主讲教师ID
     */
    private TeacherPo teacherPo;

    /**
     * 课程描述图片
     */
    private String img;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TeacherPo getTeacherPo() {
        return teacherPo;
    }

    public void setTeacherPo(TeacherPo teacherPo) {
        this.teacherPo = teacherPo;
    }

    @Override
    public String toString() {
        return "CoursePo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", outline='" + outline + '\'' +
                ", calendar='" + calendar + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", teacherPo=" + teacherPo +
                ", img='" + img + '\'' +
                '}';
    }
}