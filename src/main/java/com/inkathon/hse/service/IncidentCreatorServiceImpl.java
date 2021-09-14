package com.inkathon.hse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inkathon.hse.dao.IncidentCreatorDaoInterface;
import com.inkathon.hse.entity.IncidentCreator;

@Service
public class IncidentCreatorServiceImpl implements IncidentCreatorService {

	@Autowired
	private IncidentCreatorDaoInterface userDao;
	
	public List<IncidentCreator> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.listAllUser();
	}

	public boolean validateUser(String username,String password) {
		// TODO Auto-generated method stub
		return userDao.validate(username, password);
	}

}
