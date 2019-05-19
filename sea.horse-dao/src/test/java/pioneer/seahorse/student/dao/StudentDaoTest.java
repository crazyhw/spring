package pioneer.seahorse.student.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericDaoTestCase;
import pioneer.seahorse.student.domain.Student;

import java.util.List;

public class StudentDaoTest extends GenericDaoTestCase<Long, Student,StudentDao> {

    private static final Logger logger = LogManager.getLogger(StudentDaoTest.class.getName());
    @Autowired
    StudentDao studentDao;

    @Test
    public void testFindAll() {

        List<Student> all = this.studentDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Student> result={}", all); //$NON-NLS-1$
        }

    }
}
