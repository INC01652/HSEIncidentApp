package com.inkathon.hse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "INCIDENT_INFO")
public class IncidentInfo {
	@Id
	@Column(name="incident_id")
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
	private String incident_id;
	
	@Column(name="user_id")
	private String user_id;
	
	@Column(name="manager_id")
	private String manager_id;
	
	@Column(name="incident_type")
	private String incident_type;
	
	@Column(name="location")
	private String location;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private String status;
	
	@Column(name="Datetime")
	private String datetime;
	
	@Column(name="reason")
	private String reason;
	

	public IncidentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public IncidentInfo(String incident_id, String user_id, String manager_id, String incident_type, String location,
			String description, String status, String datetime, String reason) {
		super();
		this.incident_id = incident_id;
		this.user_id = user_id;
		this.manager_id = manager_id;
		this.incident_type = incident_type;
		this.location = location;
		this.description = description;
		this.status = status;
		this.datetime = datetime;
		this.reason = reason;
	}


	public String getIncident_id() {
		return incident_id;
	}


	public void setIncident_id(String incident_id) {
		this.incident_id = incident_id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getManager_id() {
		return manager_id;
	}


	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}


	public String getIncident_type() {
		return incident_type;
	}


	public void setIncident_type(String incident_type) {
		this.incident_type = incident_type;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDatetime() {
		return datetime;
	}


	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	@Override
	public String toString() {
		return "IncidentInfo [incident_id=" + incident_id + ", user_id=" + user_id + ", manager_id=" + manager_id
				+ ", incident_type=" + incident_type + ", location=" + location + ", description=" + description
				+ ", status=" + status + ", datetime=" + datetime + ", reason=" + reason + "]";
	}
	
	
}
