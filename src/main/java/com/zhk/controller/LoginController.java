package com.zhk.controller;

import cn.hutool.core.util.IdUtil;
import com.zhk.config.Config;
import com.zhk.entity.po.StudentPo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.entity.vo.LoginVo;
import com.zhk.service.StudentService;
import com.zhk.service.TeacherService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/login")
    public CommonResultVo login(LoginVo loginVo) {
        log.info("请求登录，账号：{}，密码：{}", loginVo.getNumber(), loginVo.getPassword());
        StudentPo studentPo = studentService.getStudentByNumber(loginVo.getNumber());
        if (studentPo != null && studentPo.getPassword().equals(loginVo.getPassword())) {
            loginVo.setToken(IdUtil.simpleUUID());
            loginVo.setUser(Config.USER_STUDENT);
            log.info("用户登录：{}", loginVo);
            return ResultUtil.success(loginVo);
        }
        return ResultUtil.fail("账号或密码错误！", loginVo);
    }

}
