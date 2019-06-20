package pioneer.seahorse.dealer.domain;
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

    @OneToMany(mappedBy = "market", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Dealer> dealers;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Market{" +
                "name='" + name + '\'' +
                '}';
    }
}
