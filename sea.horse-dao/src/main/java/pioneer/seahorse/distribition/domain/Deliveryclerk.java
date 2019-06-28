package pioneer.seahorse.distribition.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import pioneer.seahorse.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * Deliveryclerk 类
 *
 * @author 郭万江
 * @date 2019/6/27 14:41
 */
@Entity
@Table(name = "SH_Deliveryclerk")
@NamedQueries({ @NamedQuery(name = "Deliveryclerk.getRoot", query = "select s from Deliveryclerk s where s.parent is null") })
public class Deliveryclerk extends BaseTreeEntity<Deliveryclerk> {

    private static final long serialVersionUID = -8497745079229034096L;

    @Column(name = "num")
    String num;

    @Column(name = "name")
    String name;

    @Column(name = "contact")
    Integer contact;

    @NotFound(action= NotFoundAction.IGNORE)
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="x")
    @OneToMany(mappedBy = "deliveryclerk", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Order> orders;

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

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
