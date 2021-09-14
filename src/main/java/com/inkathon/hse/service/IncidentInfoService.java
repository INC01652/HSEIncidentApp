package com.inkathon.hse.service;

import java.util.List;

import com.inkathon.hse.entity.IncidentInfo;

public interface IncidentInfoService {
	
	public String save(IncidentInfo incidentInfo);
	public IncidentInfo get(String incident_id);
	List<IncidentInfo> getAllIncidentInfo();

}
