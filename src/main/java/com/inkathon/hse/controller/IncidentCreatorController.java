package com.inkathon.hse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inkathon.hse.dto.IncidentCreatorDto;
import com.inkathon.hse.entity.IncidentCreator;
import com.inkathon.hse.service.IncidentCreatorService;

@RestController
@RequestMapping("/hse")
public class IncidentCreatorController {

	@Autowired
	private IncidentCreatorService userService;

	@GetMapping("/incidentCreator")
	public List<IncidentCreator> allUsers() {
		return userService.getAllUsers();	
	}
	
	@GetMapping("/validate")
	public boolean home(@RequestParam("username") String name, @RequestParam("password") String pass) {
		if (userService.validateUser(name, pass)){
			return true;
		}
		else{
			return false;
		}
	}
	
	@PostMapping("/validate")
	public boolean save(@RequestBody IncidentCreatorDto creatorDto) {
		String name = creatorDto.getUser_id();
		String pass = creatorDto.getPassword();
		if (userService.validateUser(name, pass)){
			return true;
		}
		else{
			return false;
		}
	}	
	

}
