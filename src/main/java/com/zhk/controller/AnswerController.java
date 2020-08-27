package com.zhk.controller;

import com.zhk.entity.po.AnswerPo;
import com.zhk.entity.po.StudentPo;
import com.zhk.entity.po.TeacherPo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.AnswerService;
import com.zhk.service.StudentService;
import com.zhk.service.TeacherService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 赵洪苛
 * @date 2020/8/23 22:32
 * @description 答疑控制层
 */
@Slf4j
@RestController
public class AnswerController {

    @Resource
    private AnswerService answerService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private StudentService studentService;

    @GetMapping("/answer/{topicId}")
    public CommonResultVo<List<AnswerPo>> getAnswerByTopic(@PathVariable("topicId") Integer topicId) {
        List<AnswerPo> answerPoList = answerService.getAnswerByTopic(topicId);
        log.info("通过话题ID查询答疑消息：{}", answerPoList);
        return ResultUtil.success(answerPoList);
    }

    @GetMapping("/answer/{topicId}/{page}/{pageSize}")
    public CommonResultVo<Map<String, Object>> getAnswerByTopicAndLimit(@PathVariable("topicId") Integer topicId, @PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        List<AnswerPo> answerPoList = answerService.getAnswerByTopicAndLimit(topicId, (page - 1) * pageSize, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("list", answerPoList);
        map.put("total", answerService.countAnswerByTopic(topicId));
        log.info("通过话题ID分页查询答疑消息：{}", map);
        return ResultUtil.success(map);
    }

    @PostMapping("/answer/teacher/{teacherId}")
    public CommonResultVo insertAnswerByTeacher(@PathVariable("teacherId") Integer teacherId, @RequestBody AnswerPo answerPo) {
        TeacherPo teacherPo = teacherService.getTeacherById(teacherId);
        answerPo.setName(teacherPo.getName());
        answerPo.setNumber(teacherPo.getNumber());
        answerPo.setAvatar(teacherPo.getAvatar());
        answerPo.setPublishTime(new Date());
        answerPo = answerService.insert(answerPo);
        log.info("通过老师插入答疑消息：{}", answerPo);
        return ResultUtil.success("添加成功！");
    }

    @PostMapping("/answer/student/{studentId}")
    public CommonResultVo insertAnswerByStudent(@PathVariable("studentId") Integer studentId, @RequestBody AnswerPo answerPo) {
        StudentPo studentPo = studentService.getStudentById(studentId);
        answerPo.setName(studentPo.getName());
        answerPo.setNumber(studentPo.getNumber());
        answerPo.setAvatar(studentPo.getAvatar());
        answerPo.setPublishTime(new Date());
        answerPo = answerService.insert(answerPo);
        log.info("通过学生插入答疑消息：{}", answerPo);
        return ResultUtil.success("添加成功！");
    }

}
