package com.inkathon.hse.dao;

import java.util.List;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.inkathon.hse.entity.IncidentInfo;
import com.inkathon.hse.dto.IncidentInfoDto;
import com.inkathon.hse.entity.IncidentCreator;
import com.inkathon.hse.util.HibernateUtil;

@Repository
public class IncidentInfoDaoImp implements IncidentInfoDao {

	Transaction trans = null;
	private ArrayList<IncidentInfoDto> infoDto;

	public String save(IncidentInfo incidentInfo) {
		IncidentCreator incidentCreator = null;

		Session sessionFactory = HibernateUtil.getSessionFactory().openSession();
		trans = sessionFactory.beginTransaction();

		// adding manager_id using user_id(from Incident_Creator Table)

		if (incidentInfo.getUser_id() == null) {
			return "Provide user_id...";
		}
		incidentCreator = (IncidentCreator) sessionFactory
				.createQuery("FROM INCIDENT_CREATOR WHERE userId = :id", IncidentCreator.class)
				.setParameter("id", incidentInfo.getUser_id()).uniqueResult();
		if (incidentCreator == null) {
			return "Invalid user_id...";
		}
		incidentInfo.setManager_id(incidentCreator.getManager_id());
		String d = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(new Date());
		incidentInfo.setDatetime(d);
		sessionFactory.save(incidentInfo);
		System.out.println(incidentInfo.toString());
		trans.commit();

		return "Incident id : " + incidentInfo.getIncident_id();

	}

	public IncidentInfoDto get(String incident_id) {
		IncidentInfo info = new IncidentInfo();
		IncidentInfoDto dto = new IncidentInfoDto();
		try {
			Session sessionFactory = HibernateUtil.getSessionFactory().openSession();
			
			info = (IncidentInfo) sessionFactory.createQuery("FROM IncidentInfo WHERE incident_id = :id")
					.setParameter("id", incident_id).uniqueResult();

			
			Blob bl = info.getImage();
			byte[] b=null;
			if(bl!=null){
				try {
					b = bl.getBytes(1,(int) bl.length());
				}
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
			String s=null;
			if(b!=null)
			s = Base64.getEncoder().encodeToString(b);
			
			if(info.getIncident_id()!=null)
			dto.setIncident_id(info.getIncident_id());
			if(info.getUser_id()!=null)
			dto.setUser_id(info.getUser_id());
			if(info.getManager_id()!=null)
			dto.setManager_id(info.getManager_id());
			if(info.getIncident_type()!=null)
			dto.setIncident_type(info.getIncident_type());
			if(info.getDescription()!=null)
			dto.setDescription(info.getDescription());
			if(info.getLocation()!=null)
			dto.setLocation(info.getLocation());
			if(info.getReason()!=null)
			dto.setReason(info.getReason());
			if(info.getDatetime()!=null)
			dto.setDatetime(info.getDatetime());
			if(s!=null)
			dto.setS(s);
			if(info.getStatus()!=null)
			dto.setStatus(info.getStatus());
			if(info.getFileName()!=null)
			dto.setFileName(info.getFileName());
			if(info.getFileType()!=null)
			dto.setFileType(info.getFileType());
				
			
			return dto;
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return null;
	}	
	
	public ArrayList<IncidentInfoDto> getAllIncidentInfo() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<IncidentInfo> incidentInfo=null;
		infoDto = new ArrayList<IncidentInfoDto>();
		incidentInfo = session.createQuery("FROM IncidentInfo").getResultList();
		IncidentInfo info = new IncidentInfo();
		
		for(int i=0;i<incidentInfo.size();i++){
			IncidentInfoDto dto = new IncidentInfoDto();
			info = incidentInfo.get(i);
			Blob bl = info.getImage();
			System.out.println(bl);
			byte[] b= null;
			if(bl!=null){
				try {
					b = bl.getBytes(1,(int) bl.length());
				}
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
			String s=null;
			if(b!=null)
			s = Base64.getEncoder().encodeToString(b);
			
			if(info.getIncident_id()!=null)
			dto.setIncident_id(info.getIncident_id());
			if(info.getUser_id()!=null)
			dto.setUser_id(info.getUser_id());
			if(info.getManager_id()!=null)
			dto.setManager_id(info.getManager_id());
			if(info.getIncident_type()!=null)
			dto.setIncident_type(info.getIncident_type());
			if(info.getDescription()!=null)
			dto.setDescription(info.getDescription());
			if(info.getLocation()!=null)
			dto.setLocation(info.getLocation());
			if(info.getReason()!=null)
			dto.setReason(info.getReason());
//			System.out.println(s);
			if(info.getDatetime()!=null)
			dto.setDatetime(info.getDatetime());
			if(s!=null)
			dto.setS(s);
			if(info.getStatus()!=null)
			dto.setStatus(info.getStatus());
			
			infoDto.add(dto);
		}
			
		return infoDto;
		

	}

	public List<IncidentInfoDto> userIncident(String userId) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<IncidentInfo> incidentInfo = null;
		infoDto = new ArrayList<IncidentInfoDto>();
		
		incidentInfo = session.createQuery("FROM IncidentInfo WHERE user_id = :id").setParameter("id", userId)
				.getResultList();
 
		IncidentInfo info = new IncidentInfo();
		
		for(int i=0;i<incidentInfo.size();i++){
			
			IncidentInfoDto dto = new IncidentInfoDto();
			info = incidentInfo.get(i);
			
			if(info.getIncident_id()!=null)
			dto.setIncident_id(info.getIncident_id());
			if(info.getUser_id()!=null)
			dto.setUser_id(info.getUser_id());
			if(info.getManager_id()!=null)
			dto.setManager_id(info.getManager_id());
			if(info.getIncident_type()!=null)
			dto.setIncident_type(info.getIncident_type());
			if(info.getDescription()!=null)
			dto.setDescription(info.getDescription());
			if(info.getLocation()!=null)
			dto.setLocation(info.getLocation());
			if(info.getReason()!=null)
			dto.setReason(info.getReason());
//			System.out.println(s);
			if(info.getStatus()!=null)
			dto.setStatus(info.getStatus());
			if(info.getDatetime()!=null)
			dto.setDatetime(info.getDatetime());
			if(info.getFileName()!=null)
			dto.setFileName(info.getFileName());
			if(info.getFileType()!=null)
			dto.setFileType(info.getFileType());
			
			infoDto.add(dto);
		}
			
		return infoDto;

	}


	public List<IncidentInfoDto> managerIncident(String managerId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<IncidentInfo> incidentInfo = null;
		infoDto = new ArrayList<IncidentInfoDto>();
		
		incidentInfo = session.createQuery("FROM IncidentInfo WHERE manager_id = :id").setParameter("id", managerId)
				.getResultList();

		IncidentInfo info = new IncidentInfo();
		
		for(int i=0;i<incidentInfo.size();i++){
			
			IncidentInfoDto dto = new IncidentInfoDto();
			info = incidentInfo.get(i);
			
			if(info.getIncident_id()!=null)
			dto.setIncident_id(info.getIncident_id());
			if(info.getUser_id()!=null)
			dto.setUser_id(info.getUser_id());
			if(info.getManager_id()!=null)
			dto.setManager_id(info.getManager_id());
			if(info.getIncident_type()!=null)
			dto.setIncident_type(info.getIncident_type());
			if(info.getDescription()!=null)
			dto.setDescription(info.getDescription());
			if(info.getLocation()!=null)
			dto.setLocation(info.getLocation());
			if(info.getReason()!=null)
			dto.setReason(info.getReason());
//			System.out.println(s);
			if(info.getStatus()!=null)
			dto.setStatus(info.getStatus());
			if(info.getDatetime()!=null)
			dto.setDatetime(info.getDatetime());
			if(info.getFileName()!=null)
			dto.setFileName(info.getFileName());
			if(info.getFileType()!=null)
			dto.setFileType(info.getFileType());
						
			infoDto.add(dto);
		}
			
		return infoDto;
	}

	public String update(IncidentInfoDto infoDto) {
		// TODO Auto-generated method stub
		IncidentInfo incidentInfo = new IncidentInfo();

		Session sessionFactory = HibernateUtil.getSessionFactory().openSession();
		trans = sessionFactory.beginTransaction();
		
		if(infoDto.getStatus()==null){
			return "Incident type empty";
		}
		
		incidentInfo = (IncidentInfo)sessionFactory.createQuery("FROM IncidentInfo WHERE incident_id = :id").setParameter("id", infoDto.getIncident_id()).uniqueResult();
		incidentInfo.setStatus(infoDto.getStatus());
		incidentInfo.setReason(infoDto.getReason());
		
		sessionFactory.update(incidentInfo);
		trans.commit();
		
		return "Status Updated Successfully";
	}


	public String priority(IncidentInfoDto infoDto) {
		IncidentInfo incidentInfo = new IncidentInfo();

		Session sessionFactory = HibernateUtil.getSessionFactory().openSession();
		trans = sessionFactory.beginTransaction();
		if(infoDto.getIncident_type()==null){
			return "Incident type empty";
		}
		
		incidentInfo = (IncidentInfo)sessionFactory.createQuery("FROM IncidentInfo WHERE incident_id = :id").setParameter("id", infoDto.getIncident_id()).uniqueResult();
		incidentInfo.setIncident_type(infoDto.getIncident_type());
		
		sessionFactory.update(incidentInfo);
		trans.commit();
		
		return "Priority Updated Successfully";
		
	}

}