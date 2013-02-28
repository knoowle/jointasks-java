package com.jointasks;

import com.jointasks.model.Account;
import com.jointasks.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest {
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
    public void testAddAccount() {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        Account account = new Account();
        account.setUsername("join tasks");
        account.setPassword("join tasks");
        session.save(account);
        session.getTransaction().commit();
    }
}