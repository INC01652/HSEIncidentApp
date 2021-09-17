package com.inkathon.hse.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "INCIDENT_REVIEWER")

public class IncidentReviewer {

	@Id
	@Column(name="MANAGER_ID")
	private String managerId;
	@Column(name="NAME")
	private String name;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="MOBILE_No")
	private int mobileNo;
	@Column(name="ADDRESS")
	private String address;
	
	public IncidentReviewer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IncidentReviewer(String managerId, String name, String password, int mobileNo, String address) {
		super();
		this.managerId = managerId;
		this.name = name;
		this.password = password;
		this.mobileNo = mobileNo;
		this.address = address;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
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

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "IncidentReviewer [managerId=" + managerId + ", name=" + name + ", password=" + password + ", mobileNo="
				+ mobileNo + ", address=" + address + "]";
	}	

}
