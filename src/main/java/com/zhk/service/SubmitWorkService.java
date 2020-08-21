package com.zhk.service;

import com.zhk.entity.po.SubmitWorkPo;

import java.util.List;

/**
 * (SubmitWork)表服务接口
 *
 * @author 赵洪苛
 * @date 2020-08-19 16:11:14
 */
public interface SubmitWorkService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubmitWorkPo getSubmitWorkById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SubmitWorkPo> limit(int offset, int limit);

    /**
     * 通过workId查询提交的数据实例
     *
     * @param workId WorkPo主键
     * @return 对象列表
     */
    List<SubmitWorkPo> getSubmitWorkByWorkId(Integer workId);

    /**
     * 新增数据
     *
     * @param submitWorkPo 实例对象
     * @return 实例对象
     */
    SubmitWorkPo insert(SubmitWorkPo submitWorkPo);

    /**
     * 修改数据
     *
     * @param submitWorkPo 实例对象
     * @return 实例对象
     */
    SubmitWorkPo update(SubmitWorkPo submitWorkPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}