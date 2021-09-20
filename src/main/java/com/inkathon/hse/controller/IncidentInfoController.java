package com.inkathon.hse.controller;

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
import com.inkathon.hse.service.IncidentInfoService;

@RestController
@RequestMapping("/info")
public class IncidentInfoController {

	@Autowired
	private IncidentInfoService incidentInfoService;

	
	ObjectMapper objectMapper = new ObjectMapper();
		
		// add a new incident
		@PostMapping("/incidentInfo")
		public String save(@RequestBody IncidentInfoDto incidentInfo) {
			String incident_id = incidentInfoService.save(incidentInfo);
			return incident_id;
		}

	
		// get incidents by user_id to show on user history page
		@PostMapping("/userIncidentInfo")
		public List<IncidentInfo> userIncidents(@RequestBody IncidentInfoDto infoDto) {
			System.out.println(infoDto.getUser_id());
			List<IncidentInfo> incidentInfo = incidentInfoService.userIncident(infoDto.getUser_id());
			return incidentInfo;
		}
	
		
		//get incidents by manager_id to show on manager history page
		@PostMapping("/managerIncidentInfo")
		public List<IncidentInfo> managerIncidents(@RequestBody IncidentInfoDto infoDto) {
			System.out.println(infoDto.getManager_id());
			List<IncidentInfo> incidentInfo = incidentInfoService.managerIncident(infoDto.getManager_id());
			return incidentInfo;
		}
		
		
		//update the status of an incident
		 @PostMapping("/statusUpdate")
		   public ResponseEntity<?> update(@RequestBody IncidentInfoDto infoDto) {
		      incidentInfoService.update(infoDto);
		      return ResponseEntity.ok().body("Updated successfully.");
		   }
		
		// get all incidents
		@GetMapping(value = "/incidentInfos", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> list() {
			List<IncidentInfo> incidentInfos = incidentInfoService.getAllIncidentInfo();
			Map map = new HashMap();
	        map.put("Incidents", incidentInfos);
	        return new ResponseEntity<Object>(map, HttpStatus.OK);
        
        
	}
}
