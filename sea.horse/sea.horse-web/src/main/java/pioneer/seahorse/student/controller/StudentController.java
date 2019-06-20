package pioneer.seahorse.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.student.domain.Student;
import pioneer.seahorse.student.service.StudentManager;

import java.util.Date;
import java.util.List;

 @Controller
@RequestMapping("/student")
public class StudentController extends GenericController<Student, Long, StudentManager> {
    @Autowired
    StudentManager studentManager;

    @Autowired
    public void setStudentManager(StudentManager studentManager) {
        this.studentManager=studentManager;
        this.manager=this.studentManager;
    }

    @RequestMapping(value = "/stu",method = RequestMethod.GET)
    public String suc(){
        return "student";
    }

    @ResponseBody//标识转换成JSON处理
    @GetMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Student> findAllStudent(){
        return this.manager.findAll();
    }


    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "deleteStudent",produces = "application/json;charset=utf-8")
    public Boolean deleteStudent(@RequestBody Long num){
        return this.manager.deleteStudentNum(num);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "addStudent",produces = "application/json;charset=utf-8")
    public Boolean addStudent(@RequestBody Student student){
        this.manager.save(student);
        return true;
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "updateStudent",produces = "application/json;charset=utf-8")
    public Boolean updateStudent(@RequestBody Student student){
        Student stu=this.manager.findbyStudentnum(student.getNum());
        stu.setNum(student.getNum());
        stu.setName(student.getName());
        stu.setSex(student.getSex());
        stu.setMajor(student.getMajor());
        stu.setGrade(student.getGrade());
        stu.setcla(student.getcla());
        stu.setDateModified(new Date());
        this.manager.save(stu);
        return true;
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "searchStudent",produces = "application/json;charset=utf-8")
    public Student search(@RequestBody String num) {
        Student student=this.manager.findbyStudentnum(num);
        return student;
    }
}
