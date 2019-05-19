package pioneer.seahorse.student.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.student.domain.Student;

import java.util.List;

public interface StudentManager extends GenericManager<Student, Long> {

    List<Student> findAll();

    Student findbyStudentname(String studentname);

}
