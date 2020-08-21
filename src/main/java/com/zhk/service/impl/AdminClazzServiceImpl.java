package com.zhk.service.impl;

import com.zhk.dao.AdminClazzDao;
import com.zhk.entity.po.AdminClazzPo;
import com.zhk.service.AdminClazzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AdminClazz)表服务实现类
 *
 * @author 赵洪苛
 * @date 2020-08-17 19:39:31
 */
@Service("adminClazzService")
public class AdminClazzServiceImpl implements AdminClazzService {
    @Resource
    private AdminClazzDao adminclazzDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AdminClazzPo getAdminClazzById(Integer id) {
        return this.adminclazzDao.getAdminClazzById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AdminClazzPo> limit(int offset, int limit) {
        return this.adminclazzDao.limit(offset, limit);
    }

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<AdminClazzPo> list() {
        return this.adminclazzDao.list();
    }

    /**
     * 根据实例对象查询
     *
     * @param adminClazzPo 实例对象
     * @return 对象列表
     */
    @Override
    public List<AdminClazzPo> getAdminClazz(AdminClazzPo adminClazzPo) {
        return this.adminclazzDao.getAdminClazz(adminClazzPo);
    }

    /**
     * 新增数据
     *
     * @param adminClazzPo 实例对象
     * @return 实例对象
     */
    @Override
    public AdminClazzPo insert(AdminClazzPo adminClazzPo) {
        this.adminclazzDao.insert(adminClazzPo);
        return adminClazzPo;
    }

    /**
     * 修改数据
     *
     * @param adminClazzPo 实例对象
     * @return 实例对象
     */
    @Override
    public AdminClazzPo update(AdminClazzPo adminClazzPo) {
        this.adminclazzDao.update(adminClazzPo);
        return this.getAdminClazzById(adminClazzPo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.adminclazzDao.deleteById(id) > 0;
    }
}