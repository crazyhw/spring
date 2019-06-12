package pioneer.seahorse.goods.domain;

import pioneer.seahorse.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;
/**
 * Management 类
 * @author 李培磊
 * 仓库 -- 货物：OneToMany
 * @Date  2019/4/3 15:20
 */
@Entity
@Table(name = "SH_Management")
@NamedQueries({ @NamedQuery(name = "Management.getRoot", query = "select s from Management s where s.parent is null") })
public class Management extends BaseTreeEntity<Management> {

    private static final long serialVersionUID = 2450411806894435205L;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "management", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Goods> goods;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Management{" +
                "name='" + name + '\'' +
                '}';
    }
}
