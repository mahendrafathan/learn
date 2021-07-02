package com.glits.learn.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "name")
	private String name;	
	@Column(name = "address")
	private String address;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "password")
	private String password;
	
	public Users(String name, String address, String email) {
		setName(name);
		setAddress(address);
		setEmail(email);
	}
	
	public Users() {
		
	}
	
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
}
