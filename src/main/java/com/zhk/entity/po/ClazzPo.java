package com.zhk.entity.po;

import java.io.Serializable;

/**
 * (Clazz)实体类
 *
 * @author 赵洪苛
 * @since 2020-08-18 17:16:16
 */
public class ClazzPo implements Serializable {
    private static final long serialVersionUID = -73070138279917906L;
    /**
     * 关联学生ID和课程ID
     */
    private Integer id;
    /**
     * 学生ID
     */
    private Integer studentId;
    /**
     * 课程ID
     */
    private Integer courseId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "ClazzPo{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}