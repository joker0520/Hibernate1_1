package com.test;


import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zxq.News;

public class HibernateTest {
	
	@Test
	public void test() {
		SessionFactory sessionFactory = null ;
		/**
	    public Configuration configure() throws HibernateException {
		configure( "/hibernate.cfg.xml" );
		return this;
		}
		 */
		Configuration configuration = new Configuration().configure() ;
		ServiceRegistry serviceRegistry =
					new ServiceRegistryBuilder().applySettings(configuration.getProperties())
																	  .build() ;
		sessionFactory = configuration.buildSessionFactory(serviceRegistry) ;
		Session session = sessionFactory.openSession() ;
		Transaction tx = session.beginTransaction() ;
		News news = new News() ;
		news.setAuthor("zxq");
		news.setTitle("powers");
		news.setDate(new java.sql.Date(new Date().getTime()));
		session.save(news) ;
		tx.commit(); 
		session.close() ;
		sessionFactory.close();
	}
	}
