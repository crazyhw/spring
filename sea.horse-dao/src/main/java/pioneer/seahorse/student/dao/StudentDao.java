package pioneer.seahorse.student.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.student.domain.Student;
/**
 * StudentDao
 * @author 任鑫意
 * @Date  2019/4/15 16:35
 */
@Repository("studentDao")
public interface StudentDao extends GenericDao<Student, Long> {

}
