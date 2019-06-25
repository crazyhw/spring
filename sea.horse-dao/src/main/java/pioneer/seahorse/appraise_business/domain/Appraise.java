package pioneer.seahorse.appraise_business.domain;

import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;
/**
 * Appraise 类
 * 商家评价 -- 商家：ManyToOne
 * @author 杨留阳
 * @Date  2019/3/21 16:24
 */
@Entity
@Table(name = "SH_Appraise")
public class Appraise extends BaseEntity {

    private static final long serialVersionUID = -2393699715680994416L;

    @Column(name = "name")
    String name;
    @Column(name = "number")
    String number;
    @Column(name ="evaluate")
    String evaluate;

    @ManyToOne
    @JoinColumn(name = "business_ID")
    Business business;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEvaluate() { return evaluate; }

    public void setEvaluate(String evaluate) { this.evaluate = evaluate; }

    public Business getBusiness() { return business; }

    public void setBusiness(Business business) { this.business = business; }


}

