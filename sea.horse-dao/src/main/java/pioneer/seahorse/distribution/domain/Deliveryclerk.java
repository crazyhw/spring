package pioneer.seahorse.distribution.domain;

import pioneer.seahorse.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SH_Deliveryclerk")

public class Deliveryclerk extends BaseTreeEntity<Deliveryclerk>{

    private static final long serialVersionUID = 4330355264188356170L;

    @Column(name = "name")
    String name;
    @Column(name = "phonenumber")
    String phonenumber;
    @OneToMany(mappedBy = "deliveryclerk", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Order> orders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.name = phonenumber;
    }

}
