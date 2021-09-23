package com.inkathon.hse.service;

import java.util.ArrayList;
import java.util.List;

import com.inkathon.hse.dto.IncidentInfoDto;
import com.inkathon.hse.entity.IncidentInfo;

public interface IncidentInfoService {
	
	public String save(IncidentInfoDto infoDto);
	public IncidentInfoDto get(String incident_id);
	ArrayList<IncidentInfoDto> getAllIncidentInfo();
	List<IncidentInfoDto> userIncident(String userId);
	List<IncidentInfoDto> managerIncident(String managerId);
	String update(IncidentInfoDto infoDto);
	String priority(IncidentInfoDto infoDto);
	
}
