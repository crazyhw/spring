package pioneer.seahorse.appraise_business.domain;

import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "SH_Appraise")
public class Appraise extends BaseEntity {

    private static final long serialVersionUID = -2393699715680994416L;

    @Column(name = "name")
    String name;
    @Column(name = "count")
    Integer count;
    @Column(name ="price")
    Integer price;

    @ManyToOne
    @JoinColumn(name = "business_ID")
    Business business;

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

    public Business getBusiness() { return business; }

    public void setBusiness(Business business) { this.business = business; }
}

