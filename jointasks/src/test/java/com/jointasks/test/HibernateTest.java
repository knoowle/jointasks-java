package com.jointasks.test;

import com.jointasks.model.Account;
import com.jointasks.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateTest {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void init() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @AfterClass
    public static void destroy() {
        sessionFactory.close();
    }
    
    @Test
    public void testDeleteAccount() {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        int i = session.createQuery("delete from Account a where a.id=1").executeUpdate();
        System.out.println("commit before i = " + i);
        trans.rollback();
        System.out.println("commit after i = " + i);
    }
    
    @Test
    public void testAddAccount() {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        Account account = new Account();
        account.setUsername("john");
        account.setPassword("jointasks");
        session.save(account);
        trans.commit();
    }
}
