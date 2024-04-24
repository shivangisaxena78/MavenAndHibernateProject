package com.test.MavenAndHibernate;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

//import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException ,IOException
    {
        System.out.println( "project started" );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        //creating student
        Student st=new Student();
        st.setId(101);
        st.setName("JOHN");
        st.setCity("Delhi");
        System.out.println(st);
        
        Address ad=new Address();
        ad.setStreet("street1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);
        
        //reading image
        FileInputStream fis=new FileInputStream("src/main/java/realme.png");
       byte[]data=new byte[fis.available()];
       fis.read(data);
       ad.setImage(data);
       Session session=factory.openSession();       // System.out.println(factory);
        //System.out.println(factory.isClosed());
        
        Transaction tx=session.beginTransaction();
        
        session.save(st);
        session.save(ad);
       
        tx.commit();
        
        session.close();
        System.out.println("Done");
    }
}
