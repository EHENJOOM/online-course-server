package com.zhk.controller;

import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.ResourceService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 赵洪苛
 * @date 2020/8/22 16:25
 * @description 资源控制层
 */
@Slf4j
@RestController
public class ResourceController {

    @Resource
    private ResourceService resourceService;

    @GetMapping("/resource/{courseId}")
    public CommonResultVo getResource(@PathVariable("courseId") Integer courseId) {
        LinkedHashMap resource = resourceService.getResource(courseId);
        log.info("根据courseId和teacherId查询资源列表：{}", resource);
        return ResultUtil.success(resource);
    }

    @PostMapping("/resource")
    public CommonResultVo addResource(@RequestBody Map map) {
        log.info("添加资源：{}", map.get("resourceVo"));
        resourceService.saveResource((Map) map.get("resourceVo"), Integer.valueOf((String) map.get("courseId")));
        return ResultUtil.success("成功！");
    }

}
