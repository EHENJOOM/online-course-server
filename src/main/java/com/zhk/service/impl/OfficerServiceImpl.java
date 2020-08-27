package com.zhk.service.impl;

import com.zhk.dao.OfficerDao;
import com.zhk.entity.po.OfficerPo;
import com.zhk.service.OfficerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Officer)表服务实现类
 *
 * @author 赵洪苛
 * @date 2020-08-24 21:30:27
 */
@Service("officerService")
public class OfficerServiceImpl implements OfficerService {
    @Resource
    private OfficerDao officerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OfficerPo getOfficerById(Integer id) {
        return this.officerDao.getOfficerById(id);
    }

    /**
     * 通过工号查询单条数据
     *
     * @param number 工号
     * @return 单条数据
     */
    @Override
    public OfficerPo getOfficerByNumber(String number) {
        return this.officerDao.getOfficerByNumber(number);
    }

    /**
     * 统计院教务员数
     *
     * @return 总数
     */
    @Override
    public int count() {
        return this.officerDao.count();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<OfficerPo> limit(int offset, int limit) {
        return this.officerDao.limit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param officerPo 实例对象
     * @return 实例对象
     */
    @Override
    public OfficerPo insert(OfficerPo officerPo) {
        this.officerDao.insert(officerPo);
        return officerPo;
    }

    /**
     * 修改数据
     *
     * @param officerPo 实例对象
     * @return 实例对象
     */
    @Override
    public OfficerPo update(OfficerPo officerPo) {
        this.officerDao.update(officerPo);
        return this.getOfficerById(officerPo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.officerDao.deleteById(id) > 0;
    }
}