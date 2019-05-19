package pioneer.seahorse.trade_merchant.domain;

import pioneer.seahorse.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SH_Merchant")
@NamedQueries({ @NamedQuery(name = "Merchant.getRoot", query = "select s from Merchant s where s.parent is null") })
public class Merchant extends BaseTreeEntity<Merchant> {

    private static final long serialVersionUID = -7775257910692752742L;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "merchant", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Trade> trades;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
