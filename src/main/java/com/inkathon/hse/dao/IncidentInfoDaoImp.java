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
import com.inkathon.hse.util.HibernateUtil;

@Repository
public class IncidentInfoDaoImp implements IncidentInfoDao {

	Transaction trans = null;

	public String save(IncidentInfo incidentInfo) {
		Session sessionFactory = HibernateUtil.getSessionFactory().openSession();
		trans = sessionFactory.beginTransaction();
		sessionFactory.save(incidentInfo);
		System.out.println(incidentInfo.toString());
		trans.commit();

		return incidentInfo.getIncident_id();
	}

	public IncidentInfo get(String incident_id) {
		IncidentInfo ic = null;
		try{
		Session sessionFactory = HibernateUtil.getSessionFactory().openSession();

		ic = (IncidentInfo) sessionFactory.createQuery("FROM IncidentInfo WHERE incident_id = :id").setParameter("id", incident_id).uniqueResult();
	
		System.out.println(ic.toString());
		return ic;

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

}