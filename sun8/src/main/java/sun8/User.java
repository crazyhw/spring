package sun8;
                                                    //建立实体类
import java.io.Serializable;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
                                                    //采用注解的方式代替映射文件
@Entity
@Table(name = "stu")
public class User implements Serializable{
 
	private static final long serialVersionUID = -8892552542169372174L; //主码
 
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
 
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public Integer getAge() {
		return age;
	}
 
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
