package com.inkathon.hse.dao;

//import com.inkathon.hse.entity.IncidentCreator;

public interface IncidentReviewerDao {
	//public List<IncidentCreator> listAllUser();
	public boolean validate(String username, String password);

}
