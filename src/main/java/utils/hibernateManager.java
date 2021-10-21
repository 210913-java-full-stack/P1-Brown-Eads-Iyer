package utils;

import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateManager {
    private static SessionFactory sf;

    private hibernateManager(){}

    public static SessionFactory getSessionFactory() {
        if(sf == null){
            Configuration config = new Configuration().configure();
            config.addAnnotatedClass(City.class);
            config.addAnnotatedClass(User.class);
            config.addAnnotatedClass(Booking.class);
            config.addAnnotatedClass(Flight.class);
            sf = config.buildSessionFactory();
        }
        return sf;
    }
}
