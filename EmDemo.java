package com.test.MavenAndHibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args)
	{
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        Student student1=new Student();
        student1.setId(1234);
        student1.setName("Shivangi");
        student1.setCity("Bhopal");
        
        Certificate certificate=new Certificate();
        certificate.setCourse("Android");
        certificate.setDuration("2 months");
        student1.setCerti(certificate);
        
        
        
        
        Student student2=new Student();
        student2.setId(1212);
        student2.setName("Aaradhya");
        student2.setCity("Bhopal");
        
        Certificate certificate1=new Certificate();
        certificate1.setCourse("Hibernate");
        certificate1.setDuration("1 months");
        student2.setCerti(certificate1);
        
        
        Session session=factory.openSession();    
        
       Transaction tx=session.beginTransaction();
       
       
       session.save(student1);
       session.save(student2);
       tx.commit();
        
        session.close();
        
        factory.close();
	}

}
