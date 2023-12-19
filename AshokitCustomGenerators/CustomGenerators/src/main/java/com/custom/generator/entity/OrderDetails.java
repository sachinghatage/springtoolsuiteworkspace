package com.custom.generator.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ORDER_DTLS")
@Data
public class OrderDetails {

	@Id
	@Column(name="ORDER_ID")
	private String orderId;    //OD1  OD2
	private String orderBy;
	private Date orderPlacedDate;
	
}
