package pioneer.seahorse.appraise_business.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import pioneer.seahorse.base.domain.BaseTreeEntity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SH_Business")
@NamedQueries({ @NamedQuery(name = "Business.getRoot", query = "select s from Business s where s.parent is null") })
public class Business extends BaseTreeEntity<Business> {
    private static final long serialVersionUID = -1686822085408972218L;

    @Column(name = "num")
    String num;
    @Column(name = "name")
    String name;
    @Column(name = "market")
    String market;

    @NotFound(action= NotFoundAction.IGNORE)
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="x")
    @OneToMany(mappedBy = "business", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Appraise> appraise;

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

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Set<Appraise> getAppraise() {
        return appraise;
    }

    public void setAppraise(Set<Appraise> appraise) {
        this.appraise = appraise;
    }
}
