package pioneer.seahorse.dealer.domain;

import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;
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
}
