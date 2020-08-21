package com.zhk.service.impl;

import com.zhk.dao.ClazzDao;
import com.zhk.entity.po.ClazzPo;
import com.zhk.service.ClazzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Clazz)表服务实现类
 *
 * @author 赵洪苛
 * @date 2020-08-18 17:16:17
 */
@Service("clazzService")
public class ClazzServiceImpl implements ClazzService {
    @Resource
    private ClazzDao clazzDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ClazzPo getClazzById(Integer id) {
        return this.clazzDao.getClazzById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<ClazzPo> limit(int offset, int limit) {
        return this.clazzDao.limit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param clazzPo 实例对象
     * @return 实例对象
     */
    @Override
    public ClazzPo insert(ClazzPo clazzPo) {
        this.clazzDao.insert(clazzPo);
        return clazzPo;
    }

    /**
     * 批量新增数据
     *
     * @param clazzPoList 实例对象列表
     * @return 实例对象列表
     */
    @Override
    public List<ClazzPo> insertClazzList(List<ClazzPo> clazzPoList) {
        this.clazzDao.insertClazzList(clazzPoList);
        return clazzPoList;
    }

    /**
     * 修改数据
     *
     * @param clazzPo 实例对象
     * @return 实例对象
     */
    @Override
    public ClazzPo update(ClazzPo clazzPo) {
        this.clazzDao.update(clazzPo);
        return this.getClazzById(clazzPo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.clazzDao.deleteById(id) > 0;
    }
}