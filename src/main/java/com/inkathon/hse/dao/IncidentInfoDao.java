package com.inkathon.hse.dao;

import java.util.List;

import com.inkathon.hse.entity.IncidentInfo;

public interface IncidentInfoDao {
	
	public String save(IncidentInfo incidentInfo);
	public IncidentInfo get(String incident_id);
	List<IncidentInfo> getAllIncidentInfo();
}