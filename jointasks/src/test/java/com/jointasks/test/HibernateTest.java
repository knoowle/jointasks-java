package com.jointasks.test;

import com.jointasks.model.Account;
import com.jointasks.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;

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

    public void testAddAccount() {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        Account account = new Account();
        account.setUsername("john");
        account.setPassword("jointasks");
        trans.commit();
    }
}
