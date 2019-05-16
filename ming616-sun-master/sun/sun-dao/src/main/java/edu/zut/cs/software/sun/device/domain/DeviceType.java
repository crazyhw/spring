package edu.zut.cs.software.sun.device.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.zut.cs.software.base.domain.BaseTreeEntity;

@Entity
@Table(name = "T_DEVICE_TYPE")
public class DeviceType extends BaseTreeEntity<DeviceType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3643403140196064972L;

	@Column(name = "TYPE_CODE")
	String typeCode;
}
