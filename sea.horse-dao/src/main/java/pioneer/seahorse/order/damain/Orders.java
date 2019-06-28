package pioneer.seahorse.order.damain;

import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;

/**
 * Orderss 类
 *
 * @author 张国伟
 * @date 2019/6/27 15:49
 */
@Entity
@Table(name = "SH_Orders")
public class Orders extends BaseEntity {

    private static final long serialVersionUID = -2194723808893609022L;

    @Column(name = "num")
    String num;
    @Column(name = "name")
    String name;
    @Column(name = "sale")
    String sale;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_ID")
    User user;

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

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
