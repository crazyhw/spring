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
			
			String persistenceUnitName = "applicanContext";  // persistence.xml�������unit name�����Ըı�
			
			// 1.����EntityManagerFactory
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("applicationContext.xml");
			// 2.����EntityManager
			EntityManager entityManager = factory.createEntityManager();
			// 3.��������������
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			// 4.���г־û�
			Student user = new Student();
			user.setName("hason");
			user.setage(18);
			// 5.�ύ����
			entityManager.persist(user);
			
			transaction.commit();
			// 6.�ر�EntityManager
			entityManager.close();
			// 7.�ر�EntityManagerFacoty
			factory.close();
		}
		
	}
