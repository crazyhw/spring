package pioneer.seahorse.student.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericGenerator;
import pioneer.seahorse.student.dao.StudentDao;
import pioneer.seahorse.student.domain.Student;

import java.io.FileInputStream;
import java.util.List;

/**
 * StudentGeneric 类
 *
 * @author 任鑫意
 * @date 2019/6/3 17:43
 */
public class StudentGenerator extends GenericGenerator {

    private static final Logger logger = LogManager.getLogger(StudentGenerator.class.getName());

    @Autowired
    StudentDao studentDao;

    @Test
    public void AddStudent()
    {
        try{
            XSSFWorkbook wookbook = new XSSFWorkbook(new FileInputStream("sea.horse//doc//software17.xlsx"));
            XSSFSheet sheet = wookbook.getSheetAt(0);
            int rows = sheet.getPhysicalNumberOfRows();//获取行数
            int cells = 0;

            for(int i=1;i<rows;i++)
            {
                XSSFRow row=sheet.getRow(i);
                if(row!=null)
                    cells=row.getPhysicalNumberOfCells();
            }
            System.out.println(rows+" "+cells);

            for(int i=1;i<rows;i++)
            {
                Student student = new Student();
                XSSFRow row=sheet.getRow(i);
                if(row!=null) {
                    for (int j = 1; j < cells; j++) {
                        XSSFCell cell = row.getCell(j);
                        switch(j){
                            case 1:student.setGrade(String.valueOf(cell));break;
                            case 2:student.setMajor(String.valueOf(cell));break;
                            //case 3:student.setcla(String.valueOf(cell));break;
                            case 4:student.setNum(String.valueOf(cell));break;
                            case 5:student.setName(String.valueOf(cell));break;
                            case 6:student.setSex(String.valueOf(cell));break;
                            default:System.out.println("wrong");break;
                        }
                    }
                }
                this.studentDao.save(student);
                this.studentDao.flush();
            }
            wookbook.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        List<Student> allStudent = this.studentDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("test() - List<Student> allStudent={}", allStudent); //$NON-NLS-1$
        }
    }
}
