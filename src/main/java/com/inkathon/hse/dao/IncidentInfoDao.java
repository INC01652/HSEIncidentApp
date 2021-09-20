package com.inkathon.hse.dao;

import java.util.List;

import com.inkathon.hse.dto.IncidentInfoDto;
import com.inkathon.hse.entity.IncidentInfo;

public interface IncidentInfoDao {
	
	public String save(IncidentInfo incidentInfo);
	List<IncidentInfo> getAllIncidentInfo();
	List<IncidentInfo> userIncident(String userId);
	List<IncidentInfo> managerIncident(String managerId);
	void update(IncidentInfoDto infoDto);


	
}
