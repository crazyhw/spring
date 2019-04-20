package sun8;
                                                    //建立实体类
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
                                                    //采用注解的方式代替映射文件
@Entity
@Table(name = "stu1")
/*实现Serializabl接口的目的是为类可持久化，比如在网络传输或本地存储，
  为系统的分布和异构部署提供先决条件。若没有序列化
现在我们所熟悉的远程调用，对象数据库都不可能存在
*/
public class User implements Serializable{
 
private static final long serialVersionUID = -8538734232997376332L;

	
 
	private int id;
 
	private String name;
	
	/*public User(int id,String name,int age) {
		
		this.id = id;
		this.name = name;
		this.age = age;
	}
*/
	public User() {
		// TODO Auto-generated constructor stub
	}

	private Integer age;
 
	
	@Id/*在指定主键时，如果不指定主键生成策略，默认为AUTO。*/
	@GeneratedValue
	@Column(length = 10, nullable = false)
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
	@Column(length = 20, nullable = false)
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 5, nullable = false)
	public Integer getAge() {
		return age;
	}
 
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
