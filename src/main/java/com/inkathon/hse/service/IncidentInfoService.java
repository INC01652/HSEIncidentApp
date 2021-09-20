package com.inkathon.hse.service;

import java.util.List;

import com.inkathon.hse.dto.IncidentInfoDto;
import com.inkathon.hse.entity.IncidentInfo;

public interface IncidentInfoService {
	
	public String save(IncidentInfoDto infoDto);
	List<IncidentInfo> getAllIncidentInfo();
	List<IncidentInfo> userIncident(String userId);
	List<IncidentInfo> managerIncident(String managerId);
	void update(IncidentInfoDto infoDto);



	
}
