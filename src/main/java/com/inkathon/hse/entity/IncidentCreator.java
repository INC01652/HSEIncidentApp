package com.inkathon.hse.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "INCIDENT_CREATOR")
public class IncidentCreator {
	@Id
	@Column(name="USER_ID")
	private String userId;
	@Column(name="MANAGER_ID")
	private String managerId;
	@Column(name="NAME")
	private String name;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="MOBILE_No")
	private int mobileNo;
	
	
	public IncidentCreator() {
		super();
		// TODO Auto-generated constructor stub
	}


	public IncidentCreator(String userId, String managerId, String name, String password, String address, int mobileNo) {
		super();
		this.userId = userId;
		this.managerId = managerId;
		this.name = name;
		this.password = password;
		this.address = address;
		this.mobileNo = mobileNo;
	}


	public String getUser_id() {
		return userId;
	}


	public void setUser_id(String userId) {
		this.userId = userId;
	}


	public String getManager_id() {
		return managerId;
	}


	public void setManager_id(String managerId) {
		this.managerId = managerId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getMobile_no() {
		return mobileNo;
	}


	public void setMobile_no(int mobileNo) {
		this.mobileNo = mobileNo;
	}


	@Override
	public String toString() {
		return "IncidentCreator [userId=" + userId + ", managerId=" + managerId + ", name=" + name + ", password="
				+ password + ", address=" + address + ", mobileNo=" + mobileNo + "]";
	}
	
	
	}
