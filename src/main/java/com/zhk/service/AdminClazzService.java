package com.zhk.service;

import com.zhk.entity.po.AdminClazzPo;

import java.util.List;

/**
 * (AdminClazz)表服务接口
 *
 * @author 赵洪苛
 * @date 2020-08-17 19:39:31
 */
public interface AdminClazzService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AdminClazzPo getAdminClazzById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AdminClazzPo> limit(int offset, int limit);

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<AdminClazzPo> list();

    /**
     * 根据实例对象查询
     *
     * @param adminClazzPo 实例对象
     * @return 对象列表
     */
    List<AdminClazzPo> getAdminClazz(AdminClazzPo adminClazzPo);

    /**
     * 新增数据
     *
     * @param adminClazzPo 实例对象
     * @return 实例对象
     */
    AdminClazzPo insert(AdminClazzPo adminClazzPo);

    /**
     * 修改数据
     *
     * @param adminClazzPo 实例对象
     * @return 实例对象
     */
    AdminClazzPo update(AdminClazzPo adminClazzPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}