package com.zhk.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.zhk.entity.po.ClazzPo;
import com.zhk.entity.po.StudentPo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.ClazzService;
import com.zhk.service.StudentService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author 赵洪苛
 * @date 2020/8/18 17:37
 * @description 教学班控制层
 */
@Slf4j
@RestController
public class ClazzController {

    @Resource
    private ClazzService clazzService;

    @Resource
    private StudentService studentService;

    /**
     * 通过查询学生信息，将其加入课程的处理方法
     * @param request
     * @return 操作结果
     */
    @PostMapping("/clazz")
    public CommonResultVo insertClazzByStudent(HttpServletRequest request) {
        log.info("查询学生信息后，批量插入clazz，data:{}", request.getParameter("data"));
        String data = request.getParameter("data");
        JSONArray jsonArray = JSONUtil.parseArray(data);
        List<ClazzPo> list = JSONUtil.toList(jsonArray, ClazzPo.class);
        clazzService.insertClazzList(list);
        return ResultUtil.success("插入成功！");
    }

    @PostMapping("/clazz/byClazz")
    public CommonResultVo insertClazzByClazz(HttpServletRequest request) {
       log.info("根据班级信息，批量插入clazz，data：{}", request.getParameter("data"));
        String data = request.getParameter("data");
        JSONArray jsonArray = JSONUtil.parseArray(data);
        log.info("jsonArray：{}", jsonArray.get(0));
        List<String> list = JSONUtil.toList(jsonArray, String.class);
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        list.forEach(clazz -> {
            List<StudentPo> students = studentService.getStudentByClazz(clazz);
            List<ClazzPo> clazzPoList = new LinkedList<>();
            students.forEach(student -> {
                ClazzPo clazzPo = new ClazzPo();
                clazzPo.setCourseId(courseId);
                clazzPo.setStudentId(student.getId());
                clazzPoList.add(clazzPo);
            });
            clazzService.insertClazzList(clazzPoList);
        });
        return ResultUtil.success("插入成功！");
    }

}
