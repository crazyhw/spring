package pioneer.seahorse.trade_merchant.domain;


import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "SH_Trade")
public class Trade extends BaseEntity {

    private static final long serialVersionUID = 803921133582079202L;

    @Column(name="name")
    String name;
    @Column(name = "number")
    Integer number;
    @Column(name = "price")
    Integer price;

    @ManyToOne
    @JoinColumn(name = "merchant_ID")
    Merchant merchant;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Merchant getMerchant() { return merchant; }

    public void setMerchant(Merchant merchant) { this.merchant = merchant; }

    @Override
    public String toString() {
        return "Trade{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", price=" + price +
                '}';
    }
}
