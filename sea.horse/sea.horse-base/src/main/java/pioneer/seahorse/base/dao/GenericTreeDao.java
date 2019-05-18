package pioneer.seahorse.base.dao;

import pioneer.seahorse.base.domain.BaseTreeEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public abstract interface GenericTreeDao<T extends BaseTreeEntity<T>, PK extends Serializable>
        extends GenericDao<T, PK> {
    List<T> getRoot();
}
