package pioneer.seahorse.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import pioneer.seahorse.student.dao.StudentDao;
import pioneer.seahorse.student.domain.Student;
import pioneer.seahorse.student.service.StudentManager;

import java.util.List;
import java.util.Optional;


@Service("studentManager")
public class StudentManagerImpl extends GenericManagerImpl<Student, Long> implements StudentManager {

    StudentDao studentDao;


    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
        this.dao = this.studentDao;
    }


    @Override
    public List<Student> getAll() {
        List<Student> result = this.dao.findAll();
        return result;
    }

    @Override
    public Student findbyStudentnum(String num) {
        Student student = null;
        List<Student> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
            if (all.get(i).getNum().equals(num))
                student=all.get(i);
            return student;
    }

    @Override
    public Boolean deleteStudentNum(Long num) {
        Optional<Student> stuList=this.dao.findById(num);
        System.out.println(stuList.get().getName());
        if(stuList.equals(null)) {
            return false;
        } else {
            this.dao.delete(stuList.get());
            return true;
        }
    }

}
