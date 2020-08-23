package com.zhk.service.impl;

import com.zhk.dao.FileDao;
import com.zhk.entity.po.FilePo;
import com.zhk.service.FileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (File)表服务实现类
 *
 * @author 赵洪苛
 * @date 2020-08-22 21:23:42
 */
@Service("fileService")
public class FileServiceImpl implements FileService {
    @Resource
    private FileDao fileDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public FilePo getFileById(Integer id) {
        return this.fileDao.getFileById(id);
    }

    /**
     * 通过courseId和teacherId查询文件信息
     *
     * @param courseId 课程ID
     * @param teacherId 教师ID
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 实例对象列表
     */
    @Override
    public List<FilePo> getFileByCourseAndTeacher(Integer courseId, Integer teacherId, Integer offset, Integer limit) {
        return this.fileDao.getFileByCourseAndTeacher(courseId, teacherId, offset, limit);
    }

    /**
     * 计算courseId和teacherId对应的总文件数
     *
     * @param courseId  课程ID
     * @param teacherId 教师ID
     * @return 记录数
     */
    @Override
    public int countByCourseAndTeacher(Integer courseId, Integer teacherId) {
        return this.fileDao.countByCourseAndTeacher(courseId, teacherId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<FilePo> limit(int offset, int limit) {
        return this.fileDao.limit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param filePo 实例对象
     * @return 实例对象
     */
    @Override
    public FilePo insert(FilePo filePo) {
        this.fileDao.insert(filePo);
        return filePo;
    }

    /**
     * 修改数据
     *
     * @param filePo 实例对象
     * @return 实例对象
     */
    @Override
    public FilePo update(FilePo filePo) {
        this.fileDao.update(filePo);
        return this.getFileById(filePo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.fileDao.deleteById(id) > 0;
    }
}