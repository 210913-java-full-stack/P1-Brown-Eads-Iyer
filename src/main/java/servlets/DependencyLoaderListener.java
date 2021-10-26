package servlets;

import services.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import utils.hibernateManager;

/**
 * sets up session from hibernateManager with each service class
 * @author James Brown
 */
public class DependencyLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        cityService.setSession(hibernateManager.getSession());
        userService.setSession(hibernateManager.getSession());
        flightService.setSession(hibernateManager.getSession());
        bookingService.setSession(hibernateManager.getSession());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        hibernateManager.closeSession();
    }
}