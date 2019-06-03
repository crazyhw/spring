package pioneer.seahorse.student.domain;


import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SH_Student")
public class Student extends BaseEntity {

    @Column(name = "grade")
    String grade;
    @Column(name = "major")
    String major;
    @Column(name = "CLASS")
    String CLASS;
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

    public String getCLASS() { return CLASS; }

    public void setCLASS(String CLASS) { this.CLASS = CLASS; }

    public String getNum() { return num; }

    public void setNum(String num) { this.num = num; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSex() { return sex; }

    public void setSex(String sex) { this.sex = sex; }

}