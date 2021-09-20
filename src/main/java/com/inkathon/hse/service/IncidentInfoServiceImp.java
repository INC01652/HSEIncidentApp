package com.inkathon.hse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inkathon.hse.dao.IncidentInfoDao;
import com.inkathon.hse.dto.IncidentInfoDto;
import com.inkathon.hse.entity.IncidentInfo;

@Service
@Transactional(readOnly=true)
public class IncidentInfoServiceImp implements IncidentInfoService {

	@Autowired
	private IncidentInfoDao incidentInfoDao;
	
	@Transactional
	public String save(IncidentInfoDto infoDto) {
		IncidentInfo incidentInfo = new IncidentInfo();
		
		if(infoDto.getUser_id() == null){
			return "Provide user_id..."; 
		}
		else{
			System.out.println(infoDto.getUser_id()+" 123");
			incidentInfo.setUser_id(infoDto.getUser_id());
			}
		System.out.println("user_id");
		if(infoDto.getIncident_type() != null)
		incidentInfo.setIncident_type(infoDto.getIncident_type());
		if(infoDto.getDescription() != null)
		incidentInfo.setDescription(infoDto.getDescription());
		if(infoDto.getLocation() != null)
		incidentInfo.setLocation(infoDto.getLocation());
		if(infoDto.getStatus()!= null)
		incidentInfo.setStatus(infoDto.getStatus());
		
		
		return incidentInfoDao.save(incidentInfo);
	}


	public List<IncidentInfo> getAllIncidentInfo() {
		return incidentInfoDao.getAllIncidentInfo();
	}
	
	public List<IncidentInfo> userIncident(String userId){
		return incidentInfoDao.userIncident(userId);
	}
	
	public List<IncidentInfo> managerIncident(String managerId){
		
		return incidentInfoDao.managerIncident(managerId);
	}
	
	public void update(IncidentInfoDto infoDto) {
		incidentInfoDao.update(infoDto);
		
	}
}
