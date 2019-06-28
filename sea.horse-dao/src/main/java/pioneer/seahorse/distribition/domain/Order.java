package pioneer.seahorse.distribition.domain;

import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;

/**
 * Distribiton 类
 *
 * @author 郭万江
 * @date 2019/6/27 14:37
 */
@Entity
@Table(name = "SH_Order")
public class Order extends BaseEntity {

    private static final long serialVersionUID = 5456200648415446953L;

    @Column(name = "num")
    String num;
    @Column(name = "name")
    String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "deliveryclerk_ID")
    Deliveryclerk deliveryclerk;

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

    public Deliveryclerk getDeliveryclerk() {
        return deliveryclerk;
    }

    public void setDeliveryclerk(Deliveryclerk deliveryclerk) {
        this.deliveryclerk = deliveryclerk;
    }
}
