package com.zhk.controller;

import com.zhk.config.Config;
import com.zhk.entity.po.SubmitWorkPo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.SubmitWorkService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵洪苛
 * @date 2020/8/26 21:37
 * @description 提交作业控制层
 */
@Slf4j
@RestController
public class SubmitWorkController {

    @Resource
    private SubmitWorkService submitWorkService;

    @GetMapping("/subWork/{studentId}/{courseId}")
    public CommonResultVo getSubmitWorkByStudentAndCourse(@PathVariable("studentId") Integer studentId, @PathVariable("courseId") Integer courseId) {
        log.info("通过学生ID查询作业，studentId：{}", studentId);
        return ResultUtil.success(submitWorkService.getSubmitWorkByStudentAndCourse(studentId, courseId));
    }

    @GetMapping("/subWork/{workId}/{page}/{pageSize}")
    public CommonResultVo getSubmitWorkByWorkAndLimit(@PathVariable("workId") Integer workId, @PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        log.info("分页查询作业，page：{}，pageSize：{}", page, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("list", submitWorkService.getSubmitWorkByWorkAndLimit(workId, (page - 1) * pageSize, pageSize));
        map.put("total", submitWorkService.countSubmitWorkByWorkAndLimit(workId));
        return ResultUtil.success(map);
    }

    @PutMapping("/subWork")
    public CommonResultVo submitWorkByStudent(@RequestBody SubmitWorkPo submitWorkPo) {
        submitWorkPo.setStatus(Config.NOT_CHECK);
        submitWorkPo = submitWorkService.update(submitWorkPo);
        log.info("学生提交作业：{}", submitWorkPo);
        return ResultUtil.success("提交成功！");
    }

}
