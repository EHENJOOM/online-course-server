package com.zhk.controller;

import com.zhk.annotation.PreventRepeatSubmit;
import com.zhk.entity.po.StudentPo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.StudentService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵洪苛
 * @date 2020/8/1 15:05
 * @description 学生信息相关操作控制层
 */
@Slf4j
@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/student")
    @PreventRepeatSubmit
    public CommonResultVo<Map<String, Object>> limitStudent(int offset, int limit) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", studentService.limit(offset, limit));
        map.put("count", studentService.count());
        log.info("Student查询请求，offset：{}，limit：{}", offset, limit);
        return ResultUtil.success(map);
    }

    @PostMapping("/student")
    public CommonResultVo<StudentPo> insertStudent(@RequestBody StudentPo studentPo) {
        studentService.insert(studentPo);
        log.info("Student添加请求，data：{}", studentPo);
        return ResultUtil.success(studentPo);
    }

    @PutMapping("/student")
    public CommonResultVo<StudentPo> updateStudent(@RequestBody StudentPo studentPo) {
        studentService.update(studentPo);
        log.info("Student修改请求，data：{}", studentPo);
        return ResultUtil.success(studentPo);
    }

    @DeleteMapping("/student")
    public CommonResultVo deleteStudent(@RequestBody Integer id) {
        studentService.deleteById(id);
        log.info("Student删除请求，删除Id：{}", id);
        return ResultUtil.success(null);
    }

}