package edu.zut.cs.software.sun.order.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.zut.cs.software.base.domain.BaseEntity;

@Entity
@Table(name = "T_ORDER")
public class Order extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -31279394964769200L;

	@Column(name="CODE")
	String code;

	@Column(name="ORDER_TIME")
	Date orderTime;

	@Column(name="PRICE")
	float price;

	public String getCode() {
		return code;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public float getPrice() {
		return price;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
