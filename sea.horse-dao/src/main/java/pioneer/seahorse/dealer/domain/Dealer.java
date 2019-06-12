package pioneer.seahorse.dealer.domain;

import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;
/**
 * Dealer 类
 * @author 白疆银
 * 商家 -- 区域（市场）：ManyToOne
 * @Date  2019/3/24 13:28
 */
@Entity
@Table(name = "SH_Dealer")

public class Dealer extends BaseEntity {
    private static final long serialVersionUID = -45540597375995815L;
    @Column(name="name")
    String name;
    @Column(name="address")
    String address;
    @Column(name = "contact")
    Integer contact;
    @ManyToOne
    @JoinColumn(name = "market_ID")
    Market market;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getContact() {
        return contact;
    }
    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact=" + contact +
                '}';
    }
}
