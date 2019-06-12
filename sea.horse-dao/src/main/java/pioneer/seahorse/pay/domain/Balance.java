package pioneer.seahorse.pay.domain;
import pioneer.seahorse.base.domain.BaseEntity;
import pioneer.seahorse.cargo_shelves.domain.Shelves;

import javax.persistence.*;
/**
 * Balance 类
 * @author 吕庆宇
 * 支付方式 -- 顾客：ManyToOne
 * @Date  2019/4/5 16:32
 */
@Entity
@Table(name = "SH_Balance")
public class Balance extends BaseEntity {
    @Column(name="method")
    String method;

    @Column(name = "price")
    Integer price;

    @ManyToOne
    @JoinColumn(name = "customer_ID")
    Customer customer;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "method='" + method + '\'' +
                ", price=" + price +
                '}';
    }
}
