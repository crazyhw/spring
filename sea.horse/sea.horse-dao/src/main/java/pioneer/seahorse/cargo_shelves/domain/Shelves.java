package pioneer.seahorse.cargo_shelves.domain;

import pioneer.seahorse.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * Cargo 类
 * 货架 -- 货物：OneToMany
 * @author 任鑫意
 * @Date  2019/3/21 16:18
 */
@Entity
@Table(name = "SH_Shelves")
@NamedQueries({ @NamedQuery(name = "Shelves.getRoot", query = "select s from Shelves s where s.parent is null") })
public class Shelves extends BaseTreeEntity<Shelves> {

    private static final long serialVersionUID = 4330355264188356170L;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "shelves", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Cargo> cargos;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(Set<Cargo> cargos) {
        this.cargos = cargos;
    }

    @Override
    public String toString() {
        return "Shelves{" +
                "name='" + name + '\'' +
                '}';
    }
}
