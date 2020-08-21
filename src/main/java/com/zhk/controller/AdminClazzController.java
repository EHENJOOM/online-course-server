package com.zhk.controller;

import com.zhk.config.Config;
import com.zhk.entity.po.AdminClazzPo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.AdminClazzService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 赵洪苛
 * @date 2020/8/17 19:59
 * @description 行政班控制层
 */
@Slf4j
@RestController
public class AdminClazzController {

    @Resource
    private AdminClazzService adminClazzService;

    /*@GetMapping("/adminClazz")
    public CommonResultVo<List<Map<String, Object>>> getAllAdminClazz() {
        log.info("查询所有行政班请求");
        List<AdminClazzPo> list = adminClazzService.list();
        List<Map<String, Object>> result = new LinkedList<>();
        Config.ACADEMIES.forEach(academy -> {
            List<AdminClazzPo> data = list.stream().filter(temp -> Objects.equals(academy, temp.getAcademy())).collect(Collectors.toList());
            if (data.size() > 0) {
                Map<String, Object> item = new HashMap<>();
                item.put("title", academy);
                item.put("data", data);
                result.add(item);
            }
        });
        return ResultUtil.success(result);
    }*/

    @GetMapping("/adminClazz")
    public CommonResultVo getAdminClazzByObject(AdminClazzPo adminClazzPo) {
        log.info("根据学院和年级查询班级，academy：{}，grade：{}", adminClazzPo.getAcademy(), adminClazzPo.getGrade());
        return ResultUtil.success(adminClazzService.getAdminClazz(adminClazzPo));
    }

}
