package com.inkathon.hse.dto;

public class IncidentReviewerDto {

	private String managerId;
	private String name;
	private String password;
	private int mobileNo;
	private String address;
	
	public IncidentReviewerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IncidentReviewerDto(String managerId, String name, String password, int mobileNo, String address) {
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
