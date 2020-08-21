package com.zhk.entity.po;

import java.io.Serializable;

/**
 * (AdminClazz)实体类
 *
 * @author 赵洪苛
 * @since 2020-08-17 19:39:31
 */
public class AdminClazzPo implements Serializable {
    private static final long serialVersionUID = 186009452576185037L;
    /**
     * 行政班ID
     */
    private Integer id;
    /**
     * 行政班编号
     */
    private String code;
    /**
     * 行政班名称
     */
    private String name;
    /**
     * 行政班所属院系
     */
    private String academy;
    /**
     * 行政班所属年级
     */
    private String grade;
    /**
     * 行政班班级人数
     */
    private Integer count;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


}