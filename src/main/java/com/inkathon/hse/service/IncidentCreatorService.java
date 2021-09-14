package com.inkathon.hse.service;

import java.util.List;

import com.inkathon.hse.entity.IncidentCreator;

public interface IncidentCreatorService {
	public List<IncidentCreator> getAllUsers();
	public boolean validateUser(String username,String password);
}
