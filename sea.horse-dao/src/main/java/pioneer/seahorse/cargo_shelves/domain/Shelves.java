package pioneer.seahorse.cargo_shelves.domain;

import pioneer.seahorse.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

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
}
