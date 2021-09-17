package com.inkathon.hse.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.inkathon.hse.entity.IncidentReviewer;
import com.inkathon.hse.util.HibernateUtil;

@Repository
public class IncidentReviewerDaoImp implements IncidentReviewerDao {

	public boolean validate(String username, String password) {
		IncidentReviewer incidentReviewer = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			// authenticate Incident Creator
			System.out.println(username+" "+ password);
			incidentReviewer = (IncidentReviewer) session
					.createQuery("FROM INCIDENT_REVIEWER IR WHERE IR.managerId = :username")
					.setParameter("username", username).uniqueResult();
			if (incidentReviewer != null && incidentReviewer.getPassword().equals(password)) {
				return true;
			}

		} catch (Exception e) {
		System.out.println(e);
		}
		
		return false;
	}

}
