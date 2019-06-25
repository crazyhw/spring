package pioneer.seahorse.trade_merchant.domain;

import pioneer.seahorse.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;
/**
 * Merchant 类
 * @author 于靖鑫
 * 商品 -- 商品评价：OneToMany
 * @Date  2019/4/7 18:10
 */
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

    public Set<Trade> getTrades() {
        return trades;
    }

    public void setTrades(Set<Trade> trades) {
        this.trades = trades;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "name='" + name + '\'' +
                '}';
    }

}
