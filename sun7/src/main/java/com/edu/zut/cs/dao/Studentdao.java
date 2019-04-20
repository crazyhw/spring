package com.edu.zut.cs.dao;

import org.springframework.data.repository.Repository;
com.edu.zut.cs.entity.Student;

 /*1.Repository��һ���սӿڣ�����һ����ǽӿ� 
15
 * 2.�����Ƕ���Ľӿڼ̳���Repository����ýӿڻᱻIOC����ʶ��Ϊһ��Repository Bean 
16
 * ע�뵽IOC�����У����������ڸýӿ��ж�������һ������Ľӿ� 
17
 * 3.ʵ����Ҳ����ͨ��һ��ע��@RepositoryDefination ע�������Repository�ӿ� 
18
 */ 

//@RepositoryDefinition(domainClass=Person.class,idClass=Integer.class)

public interface Studentdao extends Repository<Student, Integer> {

    // ͨ��id����ʵ��

   Student getById(Integer id);

}