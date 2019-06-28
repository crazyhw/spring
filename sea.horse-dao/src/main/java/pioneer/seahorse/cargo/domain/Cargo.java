package pioneer.seahorse.cargo.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;

/**
 * Cargo 类
 *
 * @author 任鑫意
 * @date 2019/6/20 17:07
 */
@Entity
@Table(name = "SH_Cargo")

public class Cargo extends BaseEntity {
    private static final long serialVersionUID = -6833228937585333122L;
    @Column(name="name")
    String name;
    @Column(name="num")
    String num;
    @Column(name="price")
    Integer price;
    @Column(name = "number")
    Integer number;
    @ManyToOne(optional = false)
    @JoinColumn(name = "shelves_ID")
    Shelves shelves;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Shelves getShelves() {
        return shelves;
    }

    public void setShelves(Shelves shelves) {
        this.shelves = shelves;
    }

}
