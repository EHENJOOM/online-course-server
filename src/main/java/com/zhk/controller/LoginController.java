package com.zhk.controller;

import com.zhk.config.Config;
import com.zhk.entity.po.StudentPo;
import com.zhk.entity.po.TeacherPo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.entity.vo.LoginVo;
import com.zhk.service.StudentService;
import com.zhk.service.TeacherService;
import com.zhk.service.TokenService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 赵洪苛
 * @date 2020/8/3 19:28
 * @description 登录控制层
 */
@Slf4j
@RestController
public class LoginController {

    @Resource
    private StudentService studentService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private TokenService tokenService;

    /**
     * 客户端权限测试，如果没有权限会被拦截器拦截，无法访问此接口；否则验证成功，直接返回
     * @return CommonResultVo
     */
    @GetMapping("/authorize")
    public CommonResultVo authorize() {
        return ResultUtil.success(null);
    }

    /**
     * 用户登录
     * @param loginVo 视图层数据
     * @return CommonResultVo
     */
    @GetMapping("/login")
    public CommonResultVo login(LoginVo loginVo) {
        log.info("请求登录，账号：{}，密码：{}", loginVo.getNumber(), loginVo.getPassword());
        StudentPo studentPo = studentService.getStudentByNumber(loginVo.getNumber());
        if (studentPo != null) {
            if (studentPo.getPassword().equals(loginVo.getPassword())) {
                loginVo.setToken(tokenService.generateToken(loginVo.getNumber()));
                loginVo.setUser(Config.USER_STUDENT);
                loginVo.setId(studentPo.getId());
                log.info("用户登录：{}", loginVo);
                return ResultUtil.success(loginVo);
            }
            return ResultUtil.fail("密码错误！", loginVo);
        }

        TeacherPo teacherPo = teacherService.getTeacherByNumber(loginVo.getNumber());
        if (teacherPo != null) {
            if (teacherPo.getPassword().equals(loginVo.getPassword())) {
                loginVo.setToken(tokenService.generateToken(loginVo.getNumber()));
                loginVo.setUser(Config.USER_TEACHER);
                loginVo.setId(teacherPo.getId());
                log.info("用户登录：{}", loginVo);
                return ResultUtil.success(loginVo);
            }
            return ResultUtil.fail("密码错误！", loginVo);
        }
        return ResultUtil.fail("账号不存在！", loginVo);
    }

}
