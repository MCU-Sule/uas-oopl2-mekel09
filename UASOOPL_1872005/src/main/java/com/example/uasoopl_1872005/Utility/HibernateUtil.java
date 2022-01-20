package com.example.uasoopl_1872005.Utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**Michael Sebastian Gunadi-1872005*/

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    static {
        try {
            Configuration configuration = new org.hibernate.cfg.Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
}
