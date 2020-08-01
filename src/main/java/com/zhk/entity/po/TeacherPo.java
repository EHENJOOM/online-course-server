package com.zhk.entity.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * (Teacher)实体类
 *
 * @author 赵洪苛
 * @date 2020/08/01 11:01
 */
public class TeacherPo implements Serializable {
    private static final long serialVersionUID = 458263320841866395L;
    /**
     * 教师信息唯一标识
     */
    private Integer id;
    /**
     * 教师工号
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

    @Override
    public String toString() {
        return "TeacherPo{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", birth=" + birth +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}