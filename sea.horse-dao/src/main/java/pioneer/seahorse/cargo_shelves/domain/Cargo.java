package pioneer.seahorse.cargo_shelves.domain;


import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "SH_Cargo")
public class Cargo extends BaseEntity {

    private static final long serialVersionUID = -7381157097295901181L;

    @Column(name="name")
    String name;
    @Column(name="count")
    Integer count;
    @Column(name = "price")
    Integer price;

    @ManyToOne
    @JoinColumn(name = "shelves_ID")
    Shelves shelves;

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

    public Shelves getShelves() { return shelves; }

    public void setShelves(Shelves shelves) { this.shelves = shelves; }
}
