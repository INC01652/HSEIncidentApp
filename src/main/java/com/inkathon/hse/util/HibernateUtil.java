package com.inkathon.hse.util;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.inkathon.hse.entity.IncidentCreator;
import com.inkathon.hse.entity.IncidentInfo;
import com.inkathon.hse.entity.IncidentReviewer;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.sap.db.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:sap://zeus.hana.prod.eu-central-1.whitney.dbaas.ondemand.com:23803?encrypt=true");
                settings.put(Environment.USER, "USR_D6S2NIDSHU66YPCU4E5L1AU6Q");
                settings.put(Environment.PASS, "Xd3Aw7e1eHNnuX9Qer-ue8zUVY1aOiniorTQxH2oyGqUFODZf.l34iqaoJRGVxquFUGIkEJS9S_D7AOrLylN3zqH6tRIVvxWfG05exWj5VutYJ8iAZ27mRlKnbCdaB-3");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.HANAColumnStoreDialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.AUTOCOMMIT, "true"); 
                settings.put(Environment.HBM2DDL_AUTO, "update");
//                settings.put(Environment.c)
                
                configuration.setProperties(settings);
//                configuration.addPackage("com.inkathon.hse.entity");
                configuration.addAnnotatedClass(IncidentInfo.class);
                configuration.addAnnotatedClass(IncidentCreator.class);
                configuration.addAnnotatedClass(IncidentReviewer.class);

                
                
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}