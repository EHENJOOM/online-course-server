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
 * 本项目的接口全部为Restful风格，
 * GET方法为查询数据，POST为添加数据，PUT为修改数据，DELETE为删除数据
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
    public CommonResultVo<Map<String, Object>> limitStudent(int page, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", studentService.limit((page - 1) * pageSize, pageSize));
        map.put("count", studentService.count());
        log.info("Student查询请求，page：{}，pageSize：{}", page, pageSize);
        return ResultUtil.success(map);
    }

    @PostMapping("/student")
    public CommonResultVo<StudentPo> insertStudent(@RequestBody StudentPo studentPo) {
        studentPo = studentService.insert(studentPo);
        log.info("Student添加请求，data：{}", studentPo);
        return ResultUtil.success(studentPo);
    }

    @PutMapping("/student")
    public CommonResultVo<StudentPo> updateStudent(@RequestBody StudentPo studentPo) {
        studentPo = studentService.update(studentPo);
        log.info("Student修改请求，data：{}", studentPo);
        return ResultUtil.success(studentPo);
    }

    @DeleteMapping("/student")
    public CommonResultVo deleteStudent(@RequestBody Integer id) {
        log.info("Student删除请求，删除Id：{}", id);
        if (studentService.deleteById(id)) {
            return ResultUtil.success(null);
        }
        return ResultUtil.fail("删除失败！", null);
    }

}
