package com.zhk.service.impl;

import com.zhk.dao.StudentDao;
import com.zhk.entity.po.StudentPo;
import com.zhk.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author 赵洪苛
 * @date 2020/08/01 11:01
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StudentPo getStudentById(Integer id) {
        return this.studentDao.getStudentById(id);
    }

    /**
     * 通过学号查询单条数据
     *
     * @param number 学号
     * @return 实例对象
     */
    @Override
    public StudentPo getStudentByNumber(String number) {
        return this.studentDao.getStudentByNumber(number);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<StudentPo> limit(int offset, int limit) {
        return this.studentDao.limit(offset, limit);
    }

    /**
     * 查询记录总数
     *
     * @return 记录数
     */
    @Override
    public int count() {
        return this.studentDao.count();
    }

    /**
     * 新增数据
     *
     * @param studentPo 实例对象
     * @return 实例对象
     */
    @Override
    public StudentPo insert(StudentPo studentPo) {
        this.studentDao.insert(studentPo);
        return studentPo;
    }

    /**
     * 修改数据
     *
     * @param studentPo 实例对象
     * @return 实例对象
     */
    @Override
    public StudentPo update(StudentPo studentPo) {
        this.studentDao.update(studentPo);
        return this.getStudentById(studentPo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.studentDao.deleteById(id) > 0;
    }
}