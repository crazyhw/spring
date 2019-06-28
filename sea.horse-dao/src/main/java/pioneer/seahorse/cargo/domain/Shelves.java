package pioneer.seahorse.cargo.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import pioneer.seahorse.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * shelves 类
 *
 * @author 任鑫意
 * @date 2019/6/20 17:11
 */
@Entity
@Table(name = "SH_Shelves")
@NamedQueries({ @NamedQuery(name = "Shelves.getRoot", query = "select s from Shelves s where s.parent is null") })
public class Shelves extends BaseTreeEntity<Shelves> {

    private static final long serialVersionUID = -623042604418569510L;

    @Column(name = "num")
    String num;

    @Column(name = "name")
    String name;

    @Column(name = "sum")
    Integer sum;

    @Column(name = "number")
    Integer number;

    @NotFound(action= NotFoundAction.IGNORE)
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="x")
    @OneToMany(mappedBy = "shelves", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Cargo> cargos;

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

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Set<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(Set<Cargo> cargos) {
        this.cargos = cargos;
    }

}
