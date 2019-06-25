package pioneer.seahorse.goods.domain;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import pioneer.seahorse.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;
/**
 * Management 类
 * @author lpl
 * 区域（市场） -- 商家：OneToMany
 * @Date  2019/3/24 13:28
 */
@Entity
@Table(name = "SH_Management")
@NamedQueries({ @NamedQuery(name = "Management.getRoot", query = "select s from Management s where s.parent is null") })
public class Management extends BaseTreeEntity<Management>{

    private static final long serialVersionUID = -3824859501510302648L;

    @Column(name = "name")
    String name;
    @Column(name = "number")
    Integer number;
    @Column(name = "num")
    Integer num;
    @Column(name="address")
    String address;

    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "x")
    @OneToMany(mappedBy = "management", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Goods> goodss;
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

    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Set<Goods> getGoodss() {
        return goodss;
    }

    public void setGoodss(Set<Goods> goodss) {
        this.goodss = goodss;
    }
}
