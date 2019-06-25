package pioneer.seahorse.shop_activities.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import pioneer.seahorse.base.domain.BaseTreeEntity;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author lvqingyv
 * @date 2019/6/21 19:25
 */

@Entity
@Table(name = "SH_Shop")
@NamedQueries({ @NamedQuery(name = "Shop.getRoot", query = "select s from Shop s where s.parent is null") })
public class Shop extends BaseTreeEntity<Shop> {

    private static final long serialVersionUID = 4330355264188356170L;

    @Column(name = "name")
    String name;
    @Column(name = "sale")
    Integer sale;
    @Column(name = "account")
    Integer account;

    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "x")
    @OneToMany(mappedBy = "shop", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Activities> activities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Set<Activities> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activities> activities) {
        this.activities = activities;
    }
}