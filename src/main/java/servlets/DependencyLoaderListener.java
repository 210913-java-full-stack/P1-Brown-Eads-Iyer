package servlets;

import models.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import services.cityService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import utils.hibernateManager;

public class DependencyLoaderListener implements ServletContextListener {
    Session session;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        cityService.setSessionFactory(hibernateManager.getSessionFactory());
        cityService.setSession(cityService.getSessionFactory().openSession());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if(session.isOpen()){session.close();}
    }
}
