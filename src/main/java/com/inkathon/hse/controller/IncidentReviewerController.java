package com.inkathon.hse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inkathon.hse.dto.IncidentReviewerDto;
import com.inkathon.hse.service.IncidentReviewerService;

@RestController
@RequestMapping("/hser")
public class IncidentReviewerController {
	
	@Autowired
	private IncidentReviewerService managerService;
	
	@GetMapping("/validateReviewer")
	public boolean home(@RequestParam("username") String name, @RequestParam("password") String pass) {
		if (managerService.validateReviewer(name, pass)){
			return true;
		}
		else{
			return false;
		}
	}
	
	@PostMapping("/validateReviewer")
	public boolean save(@RequestBody IncidentReviewerDto reviewerDto) {
		String name = reviewerDto.getManagerId();
		String pass = reviewerDto.getPassword();
		if (managerService.validateReviewer(name, pass)){
			return true;
		}
		else{
			return false;
		}
	}	
	
	

}
