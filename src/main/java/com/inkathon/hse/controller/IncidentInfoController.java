package com.inkathon.hse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inkathon.hse.dto.IncidentInfoDto;
import com.inkathon.hse.entity.IncidentInfo;
import com.inkathon.hse.objects.IncidentTypes;
import com.inkathon.hse.service.IncidentInfoService;

@RestController
@RequestMapping("/info")
public class IncidentInfoController {

	@Autowired
	private IncidentInfoService incidentInfoService;
	
	ObjectMapper objectMapper = new ObjectMapper();
		
		
		// get an incident by id
		@GetMapping("/incidentInfo")
		public IncidentInfoDto get(@RequestParam("incident_id") String incident_id) {
			System.out.println(incident_id);
			IncidentInfoDto incidentInfo = incidentInfoService.get(incident_id);
			return incidentInfo;
		}
	
		// add a new incident
		@PostMapping("/incidentInfo")
		public String save(@RequestBody IncidentInfoDto incidentInfo) {
			String incident_id = incidentInfoService.save(incidentInfo);
			return incident_id;
		}

	
		// get incidents by user_id to show on user history page
		@PostMapping("/userIncidentInfo")
		public List<IncidentInfoDto> userIncidents(@RequestBody IncidentInfoDto infoDto) {
			System.out.println(infoDto.getUser_id());
			List<IncidentInfoDto> incidentInfo = incidentInfoService.userIncident(infoDto.getUser_id());
			return incidentInfo;
		}
	
		
		//get incidents by manager_id to show on manager history page
		@PostMapping("/managerIncidentInfo")
		public List<IncidentInfoDto> managerIncidents(@RequestBody IncidentInfoDto infoDto) {
			System.out.println(infoDto.getManager_id());
			List<IncidentInfoDto> incidentInfo = incidentInfoService.managerIncident(infoDto.getManager_id());
			return incidentInfo;
		}
		
		
		//update the status of an incident
		 @PostMapping("/statusUpdate")
		   public String update(@RequestBody IncidentInfoDto infoDto) {
		      return incidentInfoService.update(infoDto);
		   }
		

		//manager sets the priority of the incident		 
		@PostMapping("/priorityUpdate")
		   public String priority(@RequestBody IncidentInfoDto infoDto) {
		      return incidentInfoService.priority(infoDto);
		   }
 
		 
		//Get all incident types for report
		 @PostMapping("/incidentTypesCount")
		   public IncidentTypes incidentTypesCount(@RequestBody IncidentInfoDto infoDto) {
		      return incidentInfoService.incidentTypesCount(infoDto.getManager_id());
		   }
		 
		 
		// get all incidents
		@GetMapping(value = "/incidentInfos", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> list() {
			ArrayList<IncidentInfoDto> incidentInfos = incidentInfoService.getAllIncidentInfo();
			Map map = new HashMap();
	        map.put("Incidents", incidentInfos);
	        return new ResponseEntity<Object>(map, HttpStatus.OK);
        
	}
}
