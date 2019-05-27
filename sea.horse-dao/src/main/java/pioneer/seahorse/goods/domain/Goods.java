package pioneer.seahorse.goods.domain;


import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "SH_Goods")
public class Goods extends BaseEntity {

    private static final long serialVersionUID = 2136554191278450578L;

    @Column(name="name")
    String name;
    @Column(name="count")
    Integer count;
    @Column(name = "price")
    Integer price;

    @ManyToOne
    @JoinColumn(name = "management_ID")
    Management management;

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

    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price; }

    public Management getManagement() {
        return management;
    }

    public void setManagement(Management management) {
        this.management = management;
    }
}
