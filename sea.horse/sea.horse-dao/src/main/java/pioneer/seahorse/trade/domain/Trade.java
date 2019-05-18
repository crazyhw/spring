package pioneer.seahorse.trade.domain;

import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SH_Trade")
public class Trade extends BaseEntity {
    @Column(name = "number")
    Integer number;
    @Column(name = "name")
    String name;
    @Column(name = "price")
    Integer price;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

