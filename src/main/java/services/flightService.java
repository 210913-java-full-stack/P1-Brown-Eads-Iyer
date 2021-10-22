package services;

import models.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class flightService {
    private static SessionFactory sFactory;
    private static Session session;

    public static Flight getFlightByFlightNum(int flightNum){
        return session.get(Flight.class, flightNum);
    }

    public static void saveNewFlight(Flight flight){
        session.save(flight);
    }

    public static void deleteFlight(Flight flight){
        session.delete(flight);
    }

    public static List<Flight> getAll(){
        CriteriaBuilder cBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Flight> query = cBuilder.createQuery(Flight.class);
        Root<Flight> root = query.from(Flight.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public static void setSessionFactory(SessionFactory sf){
        sFactory = sf;
    }
    public static SessionFactory getSessionFactory(){
        return sFactory;
    }
    public static void setSession(Session session){
        flightService.session = session;
    }

}