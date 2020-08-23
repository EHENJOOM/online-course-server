package com.zhk.controller;

import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.UnitService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 赵洪苛
 * @date 2020/8/23 15:26
 * @description 单元学习控制层
 */
@Slf4j
@RestController
public class UnitController {

    @Resource
    private UnitService unitService;

    @GetMapping("/unit/{courseId}")
    public CommonResultVo getUnitByCourse(@PathVariable("courseId") Integer courseId) {
        List unit = unitService.getUnit(courseId);
        log.info("根据courseId获取单元学习：{}", unit);
        return ResultUtil.success(unit);
    }

    @PostMapping("/unit")
    public CommonResultVo saveUnitByCourse(@RequestBody Map map) {
        log.info("添加单元：{}", map.get("unit"));
        unitService.saveUnit((List) map.get("unit"), Integer.valueOf((String) map.get("courseId")));
        return ResultUtil.success("保存成功！");
    }

}
