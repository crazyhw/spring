package s2;

import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

public  class BaseEntity extends BaseDomain {

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATECREATED")
	protected Date dateCreated = new Date(0);


	@Temporal(TemporalType.TIMESTAMP)
	
	@Column(name = "DATEMODIFIED")
	protected Date dateModified = new Date(0);

	/**
	 * 瀹炰綋鏄惁琚垹闄�
	 */
	@Column(name = "DELETED")
	protected Boolean deleted;

	@Column(name = "ENTITY_NAME")
	protected String entityName;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Version
	@Access(AccessType.FIELD)      //定义数据访问模式
	private long version;

	@Override
	public boolean equals(Object obj) {
		if (null != obj) {
			if (obj instanceof BaseEntity) {
				BaseEntity domain = (BaseEntity) obj;
				if (this.id == domain.id) {
					return true;
				}
			}
		}
		return false;
	}

	
	public Date getDateCreated() {
		return dateCreated;
	}




	public Date getDateModified() {
		return dateModified;
	}


	public Boolean getDeleted() {
		return deleted;
	}


	public String getEntityName() {
		return entityName;
	}


	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
