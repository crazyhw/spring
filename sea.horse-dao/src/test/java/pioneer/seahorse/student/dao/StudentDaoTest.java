package pioneer.seahorse.student.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericDaoTestCase;
import pioneer.seahorse.student.domain.Student;

import java.util.List;
/**
 * Student测试
 *
 * POI读取excel表格存入数据库SH_Student
 * 问题：读取了一遍但是存入了两遍
 *
 * @author 任鑫意
 * @Date  2019/5/28 17:52
 */
public class StudentDaoTest extends GenericDaoTestCase<Long, Student,StudentDao> {

    private static final Logger logger = LogManager.getLogger(StudentDaoTest.class.getName());
    @Autowired
    StudentDao studentDao;

    @Test
    public void testFindAll() {

        List<Student> all = this.studentDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Student> all={}", all); //$NON-NLS-1$
        }
    }
}
