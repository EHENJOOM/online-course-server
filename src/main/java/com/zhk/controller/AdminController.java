package com.zhk.controller;

import com.zhk.entity.po.AdminPo;
import com.zhk.entity.vo.CommonResultVo;
import com.zhk.service.AdminService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵洪苛
 * @date 2020/8/25 9:12
 * @description 系统管理员控制层
 */
@Slf4j
@RestController
public class AdminController {

    @Resource
    private AdminService adminService;

    @GetMapping("/admin/{adminId}")
    public CommonResultVo<AdminPo> getAdminById(@PathVariable("adminId") Integer adminId) {
        AdminPo adminPo = adminService.getAdminById(adminId);
        log.info("查询系统管理员信息：{}", adminPo);
        return ResultUtil.success(adminPo);
    }

    @GetMapping("/admin/{page}/{pageSize}")
    public CommonResultVo<Map<String, Object>> getAdminByLimit(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        log.info("分页查询系统管理员，page：{}，pageSize：{}", page, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("list", adminService.limit((page - 1) * pageSize, pageSize));
        map.put("total", adminService.count());
        return ResultUtil.success(map);
    }

    @PostMapping("/admin")
    public CommonResultVo<String> insertAdmin(@RequestBody AdminPo adminPo) {
        adminPo = adminService.insert(adminPo);
        log.info("插入系统管理员：{}", adminPo);
        return ResultUtil.success("插入成功！");
    }

    @PutMapping("/admin")
    public CommonResultVo<String> updateAdmin(@RequestBody AdminPo adminPo) {
        adminPo = adminService.update(adminPo);
        log.info("修改系统管理员：{}", adminPo);
        return ResultUtil.success("修改成功！");
    }

    @DeleteMapping("/admin/{adminId}")
    public CommonResultVo<String> deleteAdminById(@PathVariable("adminId") Integer adminId) {
        adminService.deleteById(adminId);
        return ResultUtil.success("删除成功！");
    }

}
