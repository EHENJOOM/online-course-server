package com.zhk.service;

import com.zhk.entity.po.FilePo;

import java.util.List;

/**
 * (File)表服务接口
 *
 * @author 赵洪苛
 * @date 2020-08-22 21:23:42
 */
public interface FileService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    FilePo getFileById(Integer id);

    /**
     * 通过courseId和teacherId查询文件信息
     *
     * @param courseId 课程ID
     * @param teacherId 教师ID
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 实例对象列表
     */
    List<FilePo> getFileByCourseAndTeacher(Integer courseId, Integer teacherId, Integer offset, Integer limit);

    /**
     * 计算courseId和teacherId对应的总文件数
     *
     * @param courseId 课程ID
     * @param teacherId 教师ID
     * @return 记录数
     */
    int countByCourseAndTeacher(Integer courseId, Integer teacherId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<FilePo> limit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param filePo 实例对象
     * @return 实例对象
     */
    FilePo insert(FilePo filePo);

    /**
     * 修改数据
     *
     * @param filePo 实例对象
     * @return 实例对象
     */
    FilePo update(FilePo filePo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}