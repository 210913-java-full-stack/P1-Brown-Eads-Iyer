package servlets;

import services.*;

import org.hibernate.Session;
import services.cityService;
import utils.hibernateManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        cityService.setSession(hibernateManager.getSession());
        flightService.setSession(hibernateManager.getSession());
        bookingService.setSession(hibernateManager.getSession());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        hibernateManager.closeSession();
    }
}
