package edu.zut.cs.software.base.dao;

import java.io.Serializable;

import edu.zut.cs.software.base.domain.BaseTreeEntity;

/**
 * 
 * @author liuxiaoming
 *
 * @param <PK>
 * @param <T>
 * @param <M>
 */
public class GenericTreeDaoTestCase<PK extends Serializable, T extends BaseTreeEntity<T>, M extends GenericTreeDao<T, PK>>
		extends GenericDaoTestCase<PK, T, M> {

}
