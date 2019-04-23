package s3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="stu1")
@Entity
public class User {

	@Id
	@GeneratedValue

    private Long id;
	 @Column(name="sname")
		private String sname;
    @Column(name="sage")
    private int age;
    @Column(name="sadress")
    private String address;
   
//省略构造方法和setter、getter方法
	
	
	public void setsname(String name) {
		this.sname = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setsame(String sname) {
		this.sname=sname;
		
	}
}