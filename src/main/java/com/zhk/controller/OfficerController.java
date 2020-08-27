package com.zhk.controller;

import com.zhk.entity.po.OfficerPo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.OfficerService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵洪苛
 * @date 2020/8/25 8:54
 * @description 院教务员控制层
 */
@Slf4j
@RestController
public class OfficerController {

    @Resource
    private OfficerService officerService;

    @GetMapping("/officer/{officerId}")
    public CommonResultVo<OfficerPo> getOfficerById(@PathVariable("officerId") Integer officerId) {
        OfficerPo officerPo = officerService.getOfficerById(officerId);
        log.info("查询院教务员信息：{}", officerPo);
        return ResultUtil.success(officerPo);
    }

    @GetMapping("/officer/{page}/{pageSize}")
    public CommonResultVo<Map<String, Object>> getOfficerByLimit(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        log.info("分页查询院教务员，page：{}，pageSize：{}", page, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("list", officerService.limit((page - 1) * pageSize, pageSize));
        map.put("total", officerService.count());
        return ResultUtil.success(map);
    }

    @PostMapping("/officer")
    public CommonResultVo<String> insertOfficer(@RequestBody OfficerPo officerPo) {
        officerPo = officerService.insert(officerPo);
        log.info("添加院教务员：{}", officerPo);
        return ResultUtil.success("插入成功！");
    }

    @PutMapping("/officer")
    public CommonResultVo<String> updateOfficer(@RequestBody OfficerPo officerPo) {
        officerPo = officerService.update(officerPo);
        log.info("修改院教务员：{}", officerPo);
        return ResultUtil.success("修改成功！");
    }

    @DeleteMapping("/officer/{officerId}")
    public CommonResultVo<String> deleteOfficer(@PathVariable("officerId") Integer officerId) {
        officerService.deleteById(officerId);
        log.info("删除院教务员，id：{}", officerId);
        return ResultUtil.success("删除成功！");
    }

}
