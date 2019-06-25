package pioneer.seahorse.dealer.domain;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import pioneer.seahorse.base.domain.BaseTreeEntity;
import javax.persistence.*;
import java.util.Set;
/**
 * Market 类
 * @author 白疆银
 * 区域（市场） -- 商家：OneToMany
 * @Date  2019/3/24 13:28
 */
@Entity
@Table(name = "SH_Market")
@NamedQueries({ @NamedQuery(name = "Market.getRoot", query = "select s from Market s where s.parent is null") })
public class Market extends BaseTreeEntity<Market> {

    private static final long serialVersionUID = -3824859501510302648L;

    @Column(name = "name")
    String name;
    @Column(name="address")
    String address;
    @Column(name = "number")
    Integer number;

    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "x")
    @OneToMany(mappedBy = "market", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Dealer> dealers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Dealer> getDealers() {
        return dealers;
    }

    public void setDealers(Set<Dealer> dealers) {
        this.dealers = dealers;
    }

}
