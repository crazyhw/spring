package pioneer.seahorse.distribution.domain;

import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;
/**
 * Order 类
 * @author 郭万江
 * 订单 -- 交货周期：ManyToOne
 * @Date  2019/4/1 14:12
 */
@Entity
@Table(name = "SH_Order")

public class Order extends BaseEntity{

    private static final long serialVersionUID = -7381157097295901181L;


    @Column(name="name")
    String name;
    @Column(name="orderno")
    String orderno;
    @Column(name="count")
    Integer count;
    @Column(name = "price")
    Integer price;

    @ManyToOne
    @JoinColumn(name = "deliveryclerk_ID")
    Deliveryclerk deliveryclerk;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String name) {
        this.name = orderno;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price; }

    public Deliveryclerk getDeliveryclerk() { return deliveryclerk; }

    public void setDeliveryclerk(Deliveryclerk deliveryclerk) { this.deliveryclerk = deliveryclerk; }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", orderno='" + orderno + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}