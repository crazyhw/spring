package edu.zut.cs.software.base.service;

import static org.junit.Assert.assertEquals;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import edu.zut.cs.software.base.BaseAbstractTestCase;
import edu.zut.cs.software.base.domain.BaseEntity;

@ContextConfiguration(locations = { "classpath:/applicationContextTest-resources.xml",
		"classpath:/applicationContext-dao.xml", "classpath:/applicationContext-service.xml" })
public abstract class GenericManagerTestCase<PK extends Serializable, T extends BaseEntity, M extends GenericManager<T, PK>>
		extends BaseAbstractTestCase {
	protected T entity;
	protected List<T> list;
	protected M manager;

	private Class<T> persistentClass;

	public GenericManagerTestCase(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	private void assertEntityEquals(T entity, T foundEntity) {
		assertEquals(entity.getId(), foundEntity.getId());
	}

	@Before
	public void setUp() throws Exception {
		this.entity = this.persistentClass.getDeclaredConstructor().newInstance();
	}

	@Test
	public void testCRUD() {
		if (this.entity == null) {
			try {
				this.entity = this.persistentClass.getDeclaredConstructor().newInstance();
				T newEntity = this.manager.save(this.entity);
				@SuppressWarnings("unchecked")
				PK entity_id = (PK) newEntity.getId();
				T foundEntity = this.manager.findById(entity_id);
				assertEntityEquals(newEntity, foundEntity);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}

	}

}
