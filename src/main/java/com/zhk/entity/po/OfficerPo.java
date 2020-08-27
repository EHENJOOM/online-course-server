package com.zhk.entity.po;

import java.io.Serializable;

/**
 * (Officer)实体类
 *
 * @author 赵洪苛
 * @since 2020-08-24 21:30:26
 */
public class OfficerPo implements Serializable {
    private static final long serialVersionUID = -59414270722007364L;
    /**
     * 院教务员唯一ID
     */
    private Integer id;
    /**
     * 院教务员姓名
     */
    private String name;
    /**
     * 院教务员头像地址
     */
    private String avatar;
    /**
     * 工号
     */
    private String number;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 所属学院
     */
    private String academy;
    /**
     * 性别
     */
    private String sex;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "OfficerPo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", academy='" + academy + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}