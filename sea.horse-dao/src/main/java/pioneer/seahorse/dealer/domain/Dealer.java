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
    @Column(name="num")
    String num;
    @Column(name="address")
    String address;
    @Column(name = "contact")
    String contact;
    @ManyToOne(optional = false)
    @JoinColumn(name = "market_ID")
    Market market;
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
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
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

}
