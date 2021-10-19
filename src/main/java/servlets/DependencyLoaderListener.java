package servlets;

import models.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import services.cityService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyLoaderListener implements ServletContextListener {
    Session session;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Configuration config = new Configuration().configure();
        config.addAnnotatedClass(City.class);
        config.addAnnotatedClass(User.class);
        config.addAnnotatedClass(Booking.class);
        config.addAnnotatedClass(Flight.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        cityService.setSessionFactory(sessionFactory);
        cityService.setSession(cityService.getSessionFactory().openSession());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if(session.isOpen()){session.close();}
    }
}
