package com.zhk.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 * (SubmitWork)实体类
 *
 * @author 赵洪苛
 * @since 2020-08-19 16:11:13
 */
public class SubmitWorkPo implements Serializable {
    private static final long serialVersionUID = -10660100645890183L;
    /**
     * 学生平时作业唯一标识
     */
    private Integer id;
    /**
     * 发布的作业ID
     */
    private WorkPo workPo;
    /**
     * 学生ID
     */
    private StudentPo studentPo;
    /**
     * 提交时间
     */
    private Date submit;
    /**
     * 作业状态
     */
    private Integer status;
    /**
     * 作业文件地址
     */
    private String path;
    /**
     * 作业得分
     */
    private Double score;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WorkPo getWorkId() {
        return workPo;
    }

    public void setWorkId(WorkPo workId) {
        this.workPo = workId;
    }

    public StudentPo getStudentId() {
        return studentPo;
    }

    public void setStudentId(StudentPo studentId) {
        this.studentPo = studentId;
    }

    public Date getSubmit() {
        return submit;
    }

    public void setSubmit(Date submit) {
        this.submit = submit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "SubmitWorkPo{" +
                "id=" + id +
                ", workPo=" + workPo +
                ", studentPo=" + studentPo +
                ", submit=" + submit +
                ", status=" + status +
                ", path='" + path + '\'' +
                ", score=" + score +
                '}';
    }
}