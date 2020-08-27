package com.zhk.service;

import com.zhk.entity.po.OfficerPo;

import java.util.List;

/**
 * (Officer)表服务接口
 *
 * @author 赵洪苛
 * @date 2020-08-24 21:30:27
 */
public interface OfficerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OfficerPo getOfficerById(Integer id);

    /**
     * 通过工号查询单条数据
     *
     * @param number 工号
     * @return 单条数据
     */
    OfficerPo getOfficerByNumber(String number);

    /**
     * 统计院教务员数
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
    List<OfficerPo> limit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param officerPo 实例对象
     * @return 实例对象
     */
    OfficerPo insert(OfficerPo officerPo);

    /**
     * 修改数据
     *
     * @param officerPo 实例对象
     * @return 实例对象
     */
    OfficerPo update(OfficerPo officerPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}