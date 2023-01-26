package com.anil.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="userDetails")
public class userModel  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_id;
	
	@Column(length = 30)
	@Size(min = 3,message = "Name should have at least 3 characters")
	private String name;
	
	@Column(length = 30)
	private String address;
	
	@Column(length = 30,unique = true)
	@Email
	private String email;
	
	private long number;

	public long getUser_id() {
		return user_id;
	}
	public userModel() {
		super();
	}
	public userModel(String name, String address, String email, long number) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.number = number;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
}
