package com.edu.zut.cs.dao;

import org.springframework.data.repository.Repository;
com.edu.zut.cs.entity.Student;

 /*1.Repository是一个空接口，即是一个标记接口 
15
 * 2.若我们定义的接口继承了Repository，则该接口会被IOC容器识别为一个Repository Bean 
16
 * 注入到IOC容器中，进而可以在该接口中定义满足一定规则的接口 
17
 * 3.实际上也可以通过一个注解@RepositoryDefination 注解来替代Repository接口 
18
 */ 

//@RepositoryDefinition(domainClass=Person.class,idClass=Integer.class)

public interface Studentdao extends Repository<Student, Integer> {

    // 通过id查找实体

   Student getById(Integer id);

}