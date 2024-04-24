package com.test.MavenAndHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args)
	{
		//get,load
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        Session session=factory.openSession();
        Student student=(Student)session.get(Student.class,106);
        
        session.close();
        factory.close();
        
	}
}
