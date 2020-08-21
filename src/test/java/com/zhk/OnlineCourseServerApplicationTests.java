package com.zhk;

import com.zhk.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineCourseServerApplicationTests {

    @Autowired
    private StudentService studentService;

    @Test
    void contextLoads() {
        /*StudentPo studentPo = new StudentPo();
        studentPo.setSex("女");
        studentPo.setAcademy("经济管理学院");
        studentPo.setClazz("信管1701");
        studentPo.setGrade("2017");
        studentPo.setMajor("信息管理与信息系统");
        studentPo.setName("张子桐");
        studentPo.setNumber("2017050328");
        studentPo.setPassword("1433223");
        studentPo.setBirth(new Timestamp(933479581));
        studentService.insert(studentPo);*/
        System.out.println(studentService.getStudentById(2));
    }
}
