package com.edu.zut.cs.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name="student")

public class Student {

    @Id

    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Integer id;
    @Column

    private String name;
    
	@Column
	private Integer age;
    
    
    public Integer getId() {

       return id;

    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getName() {

        return name;

    }
    public void setName(String name) {

        this.name = name;

    }
    public int getage() {

        return age;

    }

    public void setage(int email) {

        this.age = email;

    }

    
}