package com.inkathon.hse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.inkathon.hse.entity.IncidentInfo;
import com.inkathon.hse.service.IncidentInfoService;

@RestController
@RequestMapping("/info")
public class IncidentInfoController {

	@Autowired
	private IncidentInfoService incidentInfoService;

	
	ObjectMapper objectMapper = new ObjectMapper();
	
	// add a new incident
	@PostMapping("/incidentInfo")
	public String save(@RequestBody IncidentInfo incidentInfo) {
		String incident_id = incidentInfoService.save(incidentInfo);
		return "New incident has been saved with ID:" + incident_id;
	}

	// get an incident by id
	@GetMapping("/incidentInfo")
	public IncidentInfo get(@RequestParam("incident_id") String incident_id) {
		System.out.println(incident_id);
		IncidentInfo incidentInfo = incidentInfoService.get(incident_id);
		return incidentInfo;
	}

	
	// get all incidents
	@GetMapping("/incidentInfos")
	public String list() {
		List<IncidentInfo> incidentInfos = incidentInfoService.getAllIncidentInfo();
		String s="";
		try {
			s = "{ Incidents : "+objectMapper.writeValueAsString(incidentInfos)+"}";
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  s;
	}
}
