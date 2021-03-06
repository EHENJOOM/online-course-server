package com.zhk.service;

import com.zhk.entity.po.AdminPo;

import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author 赵洪苛
 * @date 2020-08-24 21:30:22
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AdminPo getAdminById(Integer id);

    /**
     * 通过工号查询单条数据
     *
     * @param number 工号
     * @return 实例对象
     */
    AdminPo getAdminByNumber(String number);

    /**
     * 查询系统管理员数量
     *
     * @return 总数
     */
    int count();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AdminPo> limit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param adminPo 实例对象
     * @return 实例对象
     */
    AdminPo insert(AdminPo adminPo);

    /**
     * 修改数据
     *
     * @param adminPo 实例对象
     * @return 实例对象
     */
    AdminPo update(AdminPo adminPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}