package pioneer.seahorse.student.domain;


import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * Student 类
 * @author 任鑫意
 * @Date  2019/4/15 16:35
 */
@Entity
@Table(name = "T_Student")
public class Student extends BaseEntity {

    @Column(name = "grade")
    String grade;
    @Column(name = "major")
    String major;
    @Column(name = "CLASS")
    String cla;
    @Column(name = "num")
    String num;
    @Column(name = "name")
    String name;
    @Column(name = "sex")
    String sex;

    public String getGrade() { return grade; }

    public void setGrade(String grade) { this.grade = grade; }

    public String getMajor() { return major; }

    public void setMajor(String major) { this.major = major; }

    public String getcla() { return cla; }

    public void setcla(String cla) { this.cla = cla; }

    public String getNum() { return num; }

    public void setNum(String num) { this.num = num; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSex() { return sex; }

    public void setSex(String sex) { this.sex = sex; }

}
