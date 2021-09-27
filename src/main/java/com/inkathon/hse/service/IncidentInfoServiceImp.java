package com.inkathon.hse.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inkathon.hse.dao.IncidentInfoDao;
import com.inkathon.hse.dto.IncidentInfoDto;
import com.inkathon.hse.entity.IncidentInfo;
import com.inkathon.hse.objects.IncidentTypes;
import com.sap.db.jdbcext.wrapper.Blob;

@Service
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
			System.out.println(infoDto.getUser_id());
			incidentInfo.setUser_id(infoDto.getUser_id());
			}
		if(infoDto.getIncident_type() != null)
		incidentInfo.setIncident_type(infoDto.getIncident_type());
		if(infoDto.getDescription() != null)
		incidentInfo.setDescription(infoDto.getDescription());
		if(infoDto.getLocation() != null)
		incidentInfo.setLocation(infoDto.getLocation());
		if(infoDto.getStatus()!= null)
		incidentInfo.setStatus(infoDto.getStatus());
		if(infoDto.getFileName()!=null) 
		incidentInfo.setFileName(infoDto.getFileName());
		if(infoDto.getFileType()!=null) 
		incidentInfo.setFileType(infoDto.getFileType());
		
		byte[] b = Base64.getDecoder().decode(infoDto.getS());
		
		if(infoDto.getS()!=null)
		{
			try {
				incidentInfo.setImage(new SerialBlob(b));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
		
		return incidentInfoDao.save(incidentInfo);
	}

	public IncidentInfoDto get(String incident_id) {
		return incidentInfoDao.get(incident_id);
	
	}

	public ArrayList<IncidentInfoDto> getAllIncidentInfo() {
		return incidentInfoDao.getAllIncidentInfo();
	}
	
	public List<IncidentInfoDto> userIncident(String userId){
		return incidentInfoDao.userIncident(userId);
	}
	
	public List<IncidentInfoDto> managerIncident(String managerId){
		
		return incidentInfoDao.managerIncident(managerId);
	}
	
	public String update(IncidentInfoDto infoDto) {
		return incidentInfoDao.update(infoDto);
		
	}

	public String priority(IncidentInfoDto infoDto) {
		return incidentInfoDao.priority(infoDto);
	}

	public IncidentTypes incidentTypesCount(String managerId) {
		// TODO Auto-generated method stub
		return incidentInfoDao.incidentCount(managerId);
	}
	
	
	
}
