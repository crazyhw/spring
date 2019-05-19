package pioneer.seahorse.student.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.student.domain.Student;

@Repository("studentDao")
public interface StudentDao extends GenericDao<Student, Long> {

}
