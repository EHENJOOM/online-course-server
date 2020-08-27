package com.zhk.service;

import com.zhk.entity.po.ClazzPo;

import java.util.List;

/**
 * (Clazz)表服务接口
 *
 * @author 赵洪苛
 * @date 2020-08-18 17:16:16
 */
public interface ClazzService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClazzPo getClazzById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ClazzPo> limit(int offset, int limit);

    /**
     * 通过学生ID查询多条数据
     *
     * @param studentId 学生ID
     * @return 对象列表
     */
    List<ClazzPo> getClazzByStudent(Integer studentId);

    /**
     * 新增数据
     *
     * @param clazzPo 实例对象
     * @return 实例对象
     */
    ClazzPo insert(ClazzPo clazzPo);

    /**
     * 批量新增数据
     *
     * @param clazzPoList 实例对象列表
     * @return 实例对象列表
     */
    List<ClazzPo> insertClazzList(List<ClazzPo> clazzPoList);

    /**
     * 修改数据
     *
     * @param clazzPo 实例对象
     * @return 实例对象
     */
    ClazzPo update(ClazzPo clazzPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}