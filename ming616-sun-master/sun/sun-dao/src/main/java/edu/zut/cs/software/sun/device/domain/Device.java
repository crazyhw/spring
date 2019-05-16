package edu.zut.cs.software.sun.device.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.zut.cs.software.base.domain.BaseEntity;

@Entity
@Table(name = "T_DEVICE")
public class Device extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2950256638725713722L;

	@Column(name = "LOCATION")
	String location;

	@Column(name = "PRICE")
	float price;

	@Column(name = "VANDOR")
	String vandor;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getVandor() {
		return vandor;
	}

	public void setVandor(String vandor) {
		this.vandor = vandor;
	}

}
