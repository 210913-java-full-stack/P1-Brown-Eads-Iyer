package utils;

import models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//TODO DOCUMENTATION
public class hibernateManager {
    private static SessionFactory sf;
    private static Session session;

    private hibernateManager(){}

    public static SessionFactory getSessionFactory() {
        if(sf == null){
            configSession();
        }
        return sf;
    }

    public static SessionFactory getSf() {return sf;}

    public static Session getSession() {
        if(sf == null){
            configSession();
            session = sf.openSession();
        }
        return sf.openSession();
    }

    private static void configSession() {
        Configuration config = new Configuration().configure();
        if(System.getProperty("TEST") == "TRUE") {
            config.setProperty("hibernate.dialect", System.getProperty("HIBERNATE_DIALECT"));
            config.setProperty("hibernate.connection.driver_class", System.getProperty("HIBERNATE_CONNECTION_DRIVER_CLASS"));
            config.setProperty("hibernate.connection.url", System.getProperty("HIBERNATE_CONNECTION_URL"));
            config.setProperty("hibernate.connection.username", System.getProperty("HIBERNATE_CONNECTION_USERNAME"));
            config.setProperty("hibernate.connection.password", System.getProperty("HIBERNATE_CONNECTION_PASSWORD"));
            config.setProperty("hibernate.hbm2ddl.auto", System.getProperty("HIBERNATE_HBM2DDL_AUTO"));
            config.setProperty("hibernate.connection.autocommit", System.getProperty("HIBERNATE_CONNECTION_AUTOCOMMIT"));
            config.setProperty("hibernate.show_sql", System.getProperty("HIBERNATE_SHOW_SQL"));
            config.setProperty("hibernate.allow_update_outside_transaction", System.getProperty("HIBERNATE_ALLOW_OUTSIDE"));
            config.setProperty("hibernate.connection.pool.size", System.getProperty("POOL_SIZE"));
        }

        config.addAnnotatedClass(User.class);
        config.addAnnotatedClass(Booking.class);
        config.addAnnotatedClass(Flight.class);
        sf = config.buildSessionFactory();
    }

    public static void closeSession() {
        session.close();
        session = null;
    }
}
