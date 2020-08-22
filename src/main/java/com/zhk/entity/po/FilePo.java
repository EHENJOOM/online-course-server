package com.zhk.entity.po;

import java.io.Serializable;

/**
 * (File)实体类
 *
 * @author 赵洪苛
 * @since 2020-08-22 21:23:41
 */
public class FilePo implements Serializable {
    private static final long serialVersionUID = 618929721208818861L;
    /**
     * 服务器文件唯一ID
     */
    private Integer id;
    /**
     * 文件逻辑名
     */
    private String logicalName;
    /**
     * 文件存储在minio的名字
     */
    private String minioName;
    /**
     * 文件存储在minio的路径
     */
    private String url;
    /**
     * 教师ID
     */
    private Integer teacherId;
    /**
     * 课程ID
     */
    private Integer courseId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogicalName() {
        return logicalName;
    }

    public void setLogicalName(String logicalName) {
        this.logicalName = logicalName;
    }

    public String getMinioName() {
        return minioName;
    }

    public void setMinioName(String minioName) {
        this.minioName = minioName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "FilePo{" +
                "id=" + id +
                ", logicalName='" + logicalName + '\'' +
                ", minioName='" + minioName + '\'' +
                ", url='" + url + '\'' +
                ", teacherId=" + teacherId +
                ", courseId=" + courseId +
                '}';
    }
}