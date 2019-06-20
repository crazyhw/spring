package pioneer.seahorse.appraise_business.domain;

import pioneer.seahorse.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;
/**
 * Business类
 * 商家 -- 商家评价：OneToMany
 * @author 杨留阳
 * @Date  2019/3/21 16:25
 */
@Entity
@Table(name = "SH_Business")
@NamedQueries({ @NamedQuery(name = "Business.getRoot", query = "select s from Business s where s.parent is null") })
public class Business extends BaseTreeEntity<Business> {

    private static final long serialVersionUID = 1017387340500414123L;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "business", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Appraise> appraise;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Business{" +
                "name='" + name + '\'' +
                '}';
    }
}
