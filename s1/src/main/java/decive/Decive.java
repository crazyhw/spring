package decive;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zut.cs.BaseEntity;
@Entity(name="decive")
@Table(name="decive")
public class Decive extends BaseEntity  //其中baseentity为抽象实体
{
	
@Column(name="location")	
private String location;
@Column(name="location")	
float price;
@Column(name="vandor")	
String vandor;





}
