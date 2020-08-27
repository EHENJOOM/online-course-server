package com.zhk.entity.vo;

import java.util.List;

/**
 * @author 赵洪苛
 * @date 2020/8/27 11:25
 * @description
 */
public class ClazzVo {

    private List<String> clazzList;
    private Integer courseId;

    public List<String> getClazzList() {
        return clazzList;
    }

    public void setClazzList(List<String> clazzList) {
        this.clazzList = clazzList;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "ClazzVo{" +
                "clazzList=" + clazzList +
                ", courseId=" + courseId +
                '}';
    }
}
