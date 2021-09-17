package com.inkathon.hse.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inkathon.hse.dao.IncidentReviewerDao;

@Service
public class IncidentReviewerServiceImp implements IncidentReviewerService {

	@Autowired
	private IncidentReviewerDao managerDao;
	
//	public List<IncidentCreator> getAllUsers() {
//		// TODO Auto-generated method stub
//		return userDao.listAllUser();
//	}

	public boolean validateReviewer(String username,String password) {
		// TODO Auto-generated method stub
		return managerDao.validate(username, password);
	}

}
