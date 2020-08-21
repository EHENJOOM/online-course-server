package com.zhk.controller;

import com.zhk.config.Config;
import com.zhk.entity.po.SubmitWorkPo;
import com.zhk.entity.po.TeacherPo;
import com.zhk.entity.po.WorkPo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.SubmitWorkService;
import com.zhk.service.TeacherService;
import com.zhk.service.WorkService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * (Work)表控制层
 * @author 赵洪苛
 * @date 2020/8/19 16:53
 * @description (Work)表控制层
 */
@Slf4j
@RestController
public class WorkController {

    @Resource
    private WorkService workService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private SubmitWorkService submitWorkService;

    @GetMapping("/work/{id}")
    public CommonResultVo<WorkPo> getWorkById(@PathVariable("id") Integer id) {
        log.info("精确查询作业，id：{}", id);
        return ResultUtil.success(workService.getWorkById(id));
    }

    @GetMapping("/work/teacher/{courseId}")
    public CommonResultVo getWorkByCourseAndTeacher(@PathVariable("courseId") Integer courseId, @RequestParam("number") String number) {
        TeacherPo teacherPo = teacherService.getTeacherByNumber(number);
        log.info("根据老师查询作业，courseId：{}，teacher number：{}", courseId, teacherPo.getNumber());
        return ResultUtil.success(workService.getWorkByCourseAndTeacher(courseId, teacherPo.getId()));
    }

    @GetMapping("/work/{page}/{pageSize}")
    public CommonResultVo<Map<String, Object>> getWorkByLimit(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", workService.limit((page - 1) * pageSize, pageSize));
        map.put("count", workService.count());
        log.info("分页查询作业，page：{}，pageSize：{}", page, pageSize);
        return ResultUtil.success(map);
    }

    @GetMapping("/work/statistics/{courseId}")
    public CommonResultVo getWorkStatisticsByCourseIdAndWork(@RequestParam Map<String, String> map, @PathVariable("courseId") Integer courseId) {
        log.info("获取统计信息，courseId：{}，作业Id：{}", courseId, map.get("workId"));
        List<SubmitWorkPo> submitWorkPoList = submitWorkService.getSubmitWorkByWorkId(Integer.valueOf(map.get("workId")));
        Map<String, Object> data = new HashMap<>();
        long total = submitWorkPoList.size();
        data.put("total", total);
        long notSubmit = total - submitWorkPoList.stream().filter(temp -> temp.getStatus() == Config.NOT_SUBMIT).count();
        data.put("notSubmit", notSubmit);
        long checked = submitWorkPoList.stream().filter(temp -> temp.getStatus() == Config.CHECKED).count();
        data.put("checked", checked);
        data.put("list", submitWorkPoList.stream().filter(temp -> temp.getStatus() == Config.CHECKED).mapToDouble(SubmitWorkPo::getScore));
        return ResultUtil.success(data);
    }

    @PostMapping("/work")
    public CommonResultVo insertWork(WorkPo workPo) {
        log.info("插入作业，data：{}", workPo);
        workService.insert(workPo);
        return ResultUtil.success("插入成功！");
    }

    @PutMapping("/work")
    public CommonResultVo<WorkPo> updateWork(@RequestBody WorkPo workPo) {
        workPo = workService.update(workPo);
        log.info("修改作业，修改后：{}", workPo);
        return ResultUtil.success(workPo);
    }

}
