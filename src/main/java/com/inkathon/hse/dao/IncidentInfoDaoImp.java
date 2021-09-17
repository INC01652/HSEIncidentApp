package com.inkathon.hse.dao;

import java.util.List;

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
	
	public String save(IncidentInfo incidentInfo) {
		IncidentCreator incidentCreator = null;
		
		Session sessionFactory = HibernateUtil.getSessionFactory().openSession();
		trans = sessionFactory.beginTransaction();

		
//		adding manager_id using user_id(from Incident_Creator Table)
		
		if(incidentInfo.getUser_id() == null){
			return "Provide user_id..."; 
		}
		incidentCreator= (IncidentCreator)sessionFactory.createQuery("FROM INCIDENT_CREATOR WHERE userId = :id",IncidentCreator.class).setParameter("id", incidentInfo.getUser_id()).uniqueResult();
		if(incidentCreator == null){
			return "Invalid user_id...";
		}
		incidentInfo.setManager_id(incidentCreator.getManager_id());
		
		sessionFactory.save(incidentInfo);
		System.out.println(incidentInfo.toString());
		trans.commit();

		return "Incident id : " + incidentInfo.getIncident_id();
		
	}

	public IncidentInfo get(String incident_id) {
		IncidentInfo info = null;
		try{
		Session sessionFactory = HibernateUtil.getSessionFactory().openSession();

		info = (IncidentInfo) sessionFactory.createQuery("FROM IncidentInfo WHERE incident_id = :id").setParameter("id", incident_id).uniqueResult();
	
		System.out.println(info.toString());
		return info;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}


	public List<IncidentInfo> getAllIncidentInfo() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<IncidentInfo> cq = cb.createQuery(IncidentInfo.class);
		Root<IncidentInfo> root = cq.from(IncidentInfo.class);
		cq.select(root);
		Query<IncidentInfo> query = session.createQuery(cq);
		return query.getResultList();

	}

	public List<IncidentInfo> userIncident(String userId){
		List<IncidentInfo> info = null;
		try{
		Session sessionFactory = HibernateUtil.getSessionFactory().openSession();

		info = sessionFactory.createQuery("FROM IncidentInfo WHERE user_id = :id AND status != 'pending'").setParameter("id", userId).getResultList();
	
		return info;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public List<IncidentInfo> userIncidentPending(String userId){
		List<IncidentInfo> info = null;
		try{
		Session sessionFactory = HibernateUtil.getSessionFactory().openSession();

		info = sessionFactory.createQuery("FROM IncidentInfo WHERE user_id = :id AND status = 'pending'").setParameter("id", userId).getResultList();
	
		System.out.println(info.toString());
		return info;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public List<IncidentInfo> managerIncident(String managerId){
		List<IncidentInfo> info = null;
		try{
		Session sessionFactory = HibernateUtil.getSessionFactory().openSession();
		System.out.println(managerId);

		info = sessionFactory.createQuery("FROM IncidentInfo WHERE manager_id = :id").setParameter("id", managerId).getResultList();
		System.out.println("Hello");
		return info;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
	public List<IncidentInfo> managerIncidentPending(String managerId){
		List<IncidentInfo> info = null;
		try{
		Session sessionFactory = HibernateUtil.getSessionFactory().openSession();

		info = sessionFactory.createQuery("FROM IncidentInfo WHERE manager_id = :id AND status = 'pending'").setParameter("id", managerId).getResultList();
	
		System.out.println(info.toString());
		return info;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	
	
}