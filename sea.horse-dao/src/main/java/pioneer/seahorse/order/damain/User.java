package pioneer.seahorse.order.damain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import pioneer.seahorse.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * User 类
 *
 * @author 张国伟
 * @date 2019/6/27 15:50
 */
@Entity
@Table(name = "SH_User")
@NamedQueries({ @NamedQuery(name = "User.getRoot", query = "select s from User s where s.parent is null") })
public class User extends BaseTreeEntity<User> {

    private static final long serialVersionUID = 12617107492041411L;

    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;
    @Column(name = "contact")
    Integer contact;

    @NotFound(action= NotFoundAction.IGNORE)
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="x")
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Orders> orders;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
