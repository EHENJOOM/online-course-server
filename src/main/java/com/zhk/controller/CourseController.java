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

    @GetMapping("/course/teacher/{teacherId}")
    public CommonResultVo<Map<String, Object>> getCourseByTeacher(@PathVariable("teacherId") Integer teacherId) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", courseService.getCourseByTeacherId(teacherId));
        log.info("根据教师ID查询课程，data：{}", map);
        return ResultUtil.success(map);
    }

    @GetMapping("/course/academy")
    public CommonResultVo<Map<String, Object>> limitByAcademy(String academy, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", courseService.limitByAcademy(academy, (page - 1) * pageSize, pageSize));
        map.put("total", courseService.countByAcademy(academy));
        log.info("根据学院分页查询课程，data：{}", map);
        return ResultUtil.success(map);
    }

    @GetMapping("/course")
    public CommonResultVo<Map<String, Object>> limit(Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", courseService.limit((page - 1) * pageSize, pageSize));
        map.put("total", courseService.count());
        log.info("分页查询课程，data：{}", map);
        return ResultUtil.success(map);
    }

    @PostMapping("/course")
    public CommonResultVo<String> insertCourse(@RequestBody CoursePo coursePo) {
        coursePo = courseService.insert(coursePo);
        log.info("插入课程：{}", coursePo);
        return ResultUtil.success("插入成功！");
    }

    @PutMapping("/course")
    public CommonResultVo editCourseDescription(@RequestBody CoursePo coursePo) {
        log.info("修改coursePo数据，修改的内容：{}", coursePo);
        courseService.update(coursePo);
        return ResultUtil.success("修改成功！");
    }

    @DeleteMapping("/course/{courseId}")
    public CommonResultVo<String> deleteCourseById(@PathVariable("courseId") Integer courseId) {
        log.info("删除课程，courseId：{}", courseId);
        courseService.deleteById(courseId);
        return ResultUtil.success("删除成功！");
    }


}
