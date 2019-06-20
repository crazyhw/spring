package pioneer.seahorse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.student.domain.Student;
import pioneer.seahorse.student.service.StudentManager;

import java.util.List;

/**
 *
 * @author 任鑫意
 * @Date  2019/5/28 20:26
 *
 */
public class StudentManagerTest extends GenericManagerTestCase<Long, Student, StudentManager> {

    private static final Logger logger = LogManager.getLogger(StudentManagerTest.class.getName());

    StudentManager studentManager;

    public StudentManagerTest() {
        super(Student.class);
    }

    @Autowired
    public void setStudentManager(StudentManager studentManager) {
        this.studentManager = studentManager;
        this.manager = this.studentManager;
    }

    @Test
    public void testGetAll() {
        List<Student> all = this.studentManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Student> all={}", all); //$NON-NLS-1$
        }
    }

}
