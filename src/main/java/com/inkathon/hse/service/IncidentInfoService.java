package com.inkathon.hse.service;

import java.util.List;

import com.inkathon.hse.dto.IncidentInfoDto;
import com.inkathon.hse.entity.IncidentInfo;

public interface IncidentInfoService {
	
	public String save(IncidentInfoDto infoDto);
	public IncidentInfo get(String incident_id);
	List<IncidentInfo> getAllIncidentInfo();
	List<IncidentInfo> userIncident(String userId);
	List<IncidentInfo> userIncidentPending(String userId);
}
