package com.zhk.entity.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * (Student)实体类
 *
 * @author 赵洪苛
 * @date 2020/08/01 11:01
 */
public class StudentPo implements Serializable {
    private static final long serialVersionUID = 420877145679795352L;
    /**
     * 学生信息唯一标识
     */
    private Integer id;
    /**
     * 学号
     */
    private String number;
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 生日
     */
    private Timestamp birth;
    /**
     * 性别
     */
    private String sex;
    /**
     * 密码
     */
    private String password;
    /**
     * 学院
     */
    private String academy;
    /**
     * 专业
     */
    private String major;
    /**
     * 年级
     */
    private String grade;
    /**
     * 行政班级
     */
    private String clazz;


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

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "StudentPo{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", birth=" + birth +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", academy='" + academy + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", clazz='" + clazz + '\'' +
                '}';
    }
}