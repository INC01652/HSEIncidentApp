package com.inkathon.hse.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.inkathon.hse.entity.IncidentCreator;
import com.inkathon.hse.util.HibernateUtil;
 
@Repository
public class IncidentCreatorDao implements IncidentCreatorDaoInterface{
		
	public List<IncidentCreator> listAllUser() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			// get all Incident Creators
			String sql = "SELECT * FROM INCIDENT_CREATOR";
			
			NativeQuery query = session.createSQLQuery(sql);
			query.addEntity(IncidentCreator.class);
			List<IncidentCreator> employees = query.list();
			return employees;
		} catch (Exception e) {
		}
		return null;

	}
	
	public boolean validate(String username, String password) {

		IncidentCreator incidentCreator = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			// authenticate Incident Creator
			incidentCreator = (IncidentCreator) session
					.createQuery("FROM INCIDENT_CREATOR IC WHERE IC.name = :username")
					.setParameter("username", username).uniqueResult();
			if (incidentCreator != null && incidentCreator.getPassword().equals(password)) {
				return true;
			}

		} catch (Exception e) {
		}

		return false;
	}
}
