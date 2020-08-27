package com.zhk.controller;

import com.zhk.config.Config;
import com.zhk.entity.po.StudentPo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.StudentService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/student/{id}")
    public CommonResultVo<StudentPo> getStudentById(@PathVariable("id") Integer id) {
        log.info("Student精确查询请求，id：{}", id);
        return ResultUtil.success(studentService.getStudentById(id));
    }

    @GetMapping("/student/{page}/{pageSize}")
    public CommonResultVo<Map<String, Object>> limitStudent(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", studentService.limit((page - 1) * pageSize, pageSize));
        map.put("total", studentService.count());
        log.info("Student分页查询请求，page：{}，pageSize：{}", page, pageSize);
        return ResultUtil.success(map);
    }

    @GetMapping("/student")
    public CommonResultVo<List<StudentPo>> getStudent(StudentPo studentPo) {
        log.info("Student根据对象查询，student:{}", studentPo);
        List<StudentPo> data = studentService.getStudent(studentPo);
        if (studentPo == null) {
            return ResultUtil.error(Config.NO_DATA, "没有匹配的数据！");
        }
        return ResultUtil.success(data);
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

    @DeleteMapping("/student/{studentId}")
    public CommonResultVo deleteStudent(@PathVariable("studentId") Integer id) {
        log.info("Student删除请求，删除Id：{}", id);
        if (studentService.deleteById(id)) {
            return ResultUtil.success(null);
        }
        return ResultUtil.fail("删除失败！", null);
    }

}
