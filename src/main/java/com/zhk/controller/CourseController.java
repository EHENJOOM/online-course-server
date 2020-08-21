package com.zhk.controller;

import com.zhk.entity.po.CoursePo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.CourseService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵洪苛
 * @date 2020/8/8 21:29
 * @description 课程控制层
 */
@Slf4j
@RestController
public class CourseController {

    @Resource
    private CourseService courseService;

    @GetMapping("/course/{id}")
    public CommonResultVo<CoursePo> getCourseById(@PathVariable("id") Integer id) {
        log.info("course精确查询请求，CourseId：{}", id);
        return ResultUtil.success(courseService.getCourseById(id));
    }

    @PutMapping("/course")
    public CommonResultVo editCourseDescription(@RequestBody CoursePo coursePo) {
        log.info("修改coursePo数据，修改的内容：{}", coursePo);
        courseService.update(coursePo);
        return ResultUtil.success("修改成功！");
    }

    @GetMapping("/course/teacher/{teacherId}")
    public CommonResultVo<Map<String, Object>> getCourseByTeacher(@PathVariable("teacherId") Integer teacherId) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", courseService.getCourseByTeacherId(teacherId));
        log.info("根据教师ID查询课程，data：{}", map);
        return ResultUtil.success(map);
    }

    @GetMapping("/course")
    public CommonResultVo<Map<String, Object>> limit(Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", courseService.limit((page - 1) * pageSize, pageSize));
        map.put("count", courseService.count());
        log.info("分页查询，data：{}", map);
        return ResultUtil.success(map);
    }

}
