package com.zhk.controller;

import com.zhk.annotation.PreventRepeatSubmit;
import com.zhk.entity.po.TeacherPo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.TeacherService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵洪苛
 * @date 2020/8/1 22:30
 * @description 教师信息相关操作控制层
 */
@Slf4j
@RestController
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @GetMapping("/teacher")
    @PreventRepeatSubmit
    public CommonResultVo<Map<String, Object>> limitStudent(int page, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", teacherService.limit((page - 1) * pageSize, pageSize));
        map.put("count", teacherService.count());
        log.info("Teacher查询请求，page：{}，pageSize：{}", page, pageSize);
        return ResultUtil.success(map);
    }

    @PostMapping("/teacher")
    public CommonResultVo<TeacherPo> insertStudent(@RequestBody TeacherPo teacherPo) {
        teacherPo = teacherService.insert(teacherPo);
        log.info("Teacher添加请求，data：{}", teacherPo);
        return ResultUtil.success(teacherPo);
    }

    @PutMapping("/teacher")
    public CommonResultVo<TeacherPo> updateStudent(@RequestBody TeacherPo teacherPo) {
        teacherPo = teacherService.update(teacherPo);
        log.info("Teacher修改请求，data：{}", teacherPo);
        return ResultUtil.success(teacherPo);
    }

    @DeleteMapping("/teacher")
    public CommonResultVo deleteStudent(@RequestBody Integer id) {
        log.info("Teacher删除请求，删除Id：{}", id);
        if (teacherService.deleteById(id)) {
            return ResultUtil.success(null);
        }
        return ResultUtil.fail("删除失败！", null);
    }

}
