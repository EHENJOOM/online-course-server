package com.zhk.service.impl;

import com.zhk.dao.AdminDao;
import com.zhk.entity.po.AdminPo;
import com.zhk.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author 赵洪苛
 * @date 2020-08-24 21:30:22
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AdminPo getAdminById(Integer id) {
        return this.adminDao.getAdminById(id);
    }

    /**
     * 通过工号查询单条数据
     *
     * @param number 工号
     * @return 实例对象
     */
    @Override
    public AdminPo getAdminByNumber(String number) {
        return this.adminDao.getAdminByNumber(number);
    }

    /**
     * 查询系统管理员数量
     *
     * @return 总数
     */
    @Override
    public int count() {
        return this.adminDao.count();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AdminPo> limit(int offset, int limit) {
        return this.adminDao.limit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param adminPo 实例对象
     * @return 实例对象
     */
    @Override
    public AdminPo insert(AdminPo adminPo) {
        this.adminDao.insert(adminPo);
        return adminPo;
    }

    /**
     * 修改数据
     *
     * @param adminPo 实例对象
     * @return 实例对象
     */
    @Override
    public AdminPo update(AdminPo adminPo) {
        this.adminDao.update(adminPo);
        return this.getAdminById(adminPo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.adminDao.deleteById(id) > 0;
    }
}