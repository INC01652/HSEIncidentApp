package com.inkathon.hse.dao;

import java.util.List;

import com.inkathon.hse.entity.IncidentCreator;

public interface IncidentCreatorDaoInterface {
	public List<IncidentCreator> listAllUser();
	public boolean validate(String username, String password);
}	
