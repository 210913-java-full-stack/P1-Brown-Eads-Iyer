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
        config.addAnnotatedClass(City.class);
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
