package pioneer.seahorse.cargo.domain;


import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SH_Cargo")
public class Cargo extends BaseEntity {
    @Column(name="num")
    Integer num;
    @Column(name="name")
    String name;
    @Column(name="count")
    Integer count;
    @Column(name = "price")
    Integer price;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
