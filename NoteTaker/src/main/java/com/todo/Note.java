package com.todo;

import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notes")
public class Note {
	@Id
	private int id;
	private String customer_name;
	private String content;
	private Long mobile_number;
	private Date addedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCustomer_name() {
		return customer_name;
	}
	
	public void setCustomer_name(String customer_name) {
		this.customer_name=customer_name;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public Note(String customer_name, String content, Long mobile_number, Date addedDate) {
		super();
		this.id = new Random().nextInt(100000);
		this.customer_name = customer_name;
		this.content = content;
		this.mobile_number = mobile_number;
		this.addedDate = addedDate;
	}
	
//	public Note(String customer_name, String content, Date addedDate) {
////		super();
////		this.id = new Random().nextInt(100000);
////		this.customer_name = customer_name;
////		this.content = content;
////		//this.mobile_number = mobile_number;
////		this.addedDate = addedDate;
////	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
