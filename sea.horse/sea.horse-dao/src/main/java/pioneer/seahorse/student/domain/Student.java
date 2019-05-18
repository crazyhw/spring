package pioneer.seahorse.student.domain;


import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SH_Student")
public class Student extends BaseEntity {
    @Column(name = "num")
    Integer num;
    @Column(name = "id")
    String id;
    @Column(name = "name")
    String name;
    @Column(name = "sex")
    String sex;
    @Column(name = "cla")
    String cla;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }
}
