package com.zhk.entity.vo;

/**
 * VO（View Object）：显示层对象，Web向控制层传递的对象
 * @author 赵洪苛
 * @date 2020/8/5 20:02
 * @description 登录实体对象
 */
public class LoginVo {

    private String number;
    private String password;

    /**
     * Web端鉴权，会话保持
     */
    private String token;

    /**
     * 账户类型
     */
    private Integer user;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}
