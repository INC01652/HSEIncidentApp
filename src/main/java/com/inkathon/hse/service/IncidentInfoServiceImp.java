package com.inkathon.hse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inkathon.hse.dao.IncidentInfoDao;
import com.inkathon.hse.entity.IncidentInfo;

@Service
@Transactional(readOnly=true)
public class IncidentInfoServiceImp implements IncidentInfoService {

	@Autowired
	private IncidentInfoDao incidentInfoDao;
	
	@Transactional
	public String save(IncidentInfo incidentInfo) {
		return incidentInfoDao.save(incidentInfo);
	}

	public IncidentInfo get(String incident_id) {
		return incidentInfoDao.get(incident_id);
	
	}

	public List<IncidentInfo> getAllIncidentInfo() {
		return incidentInfoDao.getAllIncidentInfo();
	}

}
