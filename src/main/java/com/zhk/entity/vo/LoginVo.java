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

    @Override
    public String toString() {
        return "LoginVo{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
