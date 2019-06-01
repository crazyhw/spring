package pioneer.seahorse.distribution.domain;

import pioneer.seahorse.base.domain.BaseTreeEntity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SH_Deliveryclerk")
@NamedQueries({ @NamedQuery(name = "Deliveryclerk.getRoot", query = "select s from Deliveryclerk s where s.parent is null") })
public class Deliveryclerk extends BaseTreeEntity<Deliveryclerk> {

    private static final long serialVersionUID = 8832638149285051387L;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "deliveryclerk", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Order> orders;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}