package com.edu.zut.cs;

package com.edu.zut.cs.test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.edu.zut.cs.dao.Studentdao;
import com.edu.zut.cs.entity.Student;

public class tstapj {
public static void main(String[] args) {
			
			String persistenceUnitName = "applicanContext";  // persistence.xml配置里的unit name，可以改变
			
			// 1.创建EntityManagerFactory
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("applicationContext.xml");
			// 2.创建EntityManager
			EntityManager entityManager = factory.createEntityManager();
			// 3.创建、开启事务
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			// 4.进行持久化
			Student user = new Student();
			user.setName("hason");
			user.setage(18);
			// 5.提交事务
			entityManager.persist(user);
			
			transaction.commit();
			// 6.关闭EntityManager
			entityManager.close();
			// 7.关闭EntityManagerFacoty
			factory.close();
		}
		
	}
