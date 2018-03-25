package com.telusko.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien telusko= new Alien();
        telusko.setAid(101);
        telusko.setAname("ikenna");
        telusko.setColor("blue");
        
        Configuration con= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
        
        ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf= con.buildSessionFactory(reg);
        
        Session session= sf.openSession();
        
        Transaction tx= session.beginTransaction();
        session.save(telusko);
        tx.commit();
    }
}
