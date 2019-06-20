
package pioneer.seahorse.pay.domain;


import pioneer.seahorse.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;
/**
 * Customer 类
 * @author 吕庆宇
 * 顾客 -- 支付方式：OneToMany
 * @Date  2019/4/5 16:32
 */
@Entity
@Table(name = "SH_Customer")
@NamedQueries({ @NamedQuery(name = "Customer.getRoot", query = "select s from Customer s where s.parent is null") })
public class Customer extends BaseTreeEntity<Customer> {
    private static final long serialVersionUID = -2908272194348592905L;

    @Column(name = "name")
    String name;
    @Column(name="sex")
    String sex;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Balance> balances;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
