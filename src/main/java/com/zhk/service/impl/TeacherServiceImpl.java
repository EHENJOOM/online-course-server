package com.zhk.service.impl;

import com.zhk.dao.TeacherDao;
import com.zhk.entity.po.TeacherPo;
import com.zhk.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Teacher)表服务实现类
 *
 * @author 赵洪苛
 * @date  2020/08/01 11:01
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherDao teacherDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TeacherPo getTeacherById(Integer id) {
        return this.teacherDao.getTeacherById(id);
    }

    /**
     * 通过工号查询单条数据
     *
     * @param number 工号
     * @return 实例对象
     */
    @Override
    public TeacherPo getTeacherByNumber(String number) {
        return this.teacherDao.getTeacherByNumber(number);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TeacherPo> limit(int offset, int limit) {
        return this.teacherDao.limit(offset, limit);
    }

    /**
     * 查询记录总数
     *
     * @return 记录数
     */
    @Override
    public int count() {
        return this.teacherDao.count();
    }

    /**
     * 新增数据
     *
     * @param teacherPo 实例对象
     * @return 实例对象
     */
    @Override
    public TeacherPo insert(TeacherPo teacherPo) {
        this.teacherDao.insert(teacherPo);
        return teacherPo;
    }

    /**
     * 修改数据
     *
     * @param teacherPo 实例对象
     * @return 实例对象
     */
    @Override
    public TeacherPo update(TeacherPo teacherPo) {
        this.teacherDao.update(teacherPo);
        return this.getTeacherById(teacherPo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.teacherDao.deleteById(id) > 0;
    }
}