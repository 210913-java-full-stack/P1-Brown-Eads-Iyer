package services;

import models.City;
import models.Flight;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class flightService {
    private static Session session;

    public static Flight getFlightByFlightNum(int flightNum){
        return session.get(Flight.class, flightNum);
    }

    public static void saveNewFlight(Flight flightPatch){
        //add to this logic: connection to the cities:
        //criteria query for city that matches departure city.
        //build the whole thing...
        //root is the City class
        //.....where(builder.equal(root.get("code", flight.getDestinationCode())))
        //criteria query for the city that matches destination.
        //update those city objects (add to lists) this flight object
        //call session.flush()
        //Note: that anything we pull out of the database into a java object is now in persistent state.
        try {
            Flight flight = session.get(Flight.class, flightPatch.getFlight_number());
            if (flight == null){
                //Departure
                CriteriaBuilder cb = session.getCriteriaBuilder();
                CriteriaQuery<City> query = cb.createQuery(City.class);
                Root<City> root = query.from(City.class);
                query.where(cb.equal(root.get("code"), flightPatch.getDepartureCode()));
                List<City> list = session.createQuery(query).getResultList();
                City c = list.get(0);
                c.getDeparture().add(flightPatch);

                //Destination
                query.where(cb.equal(root.get("code"), flightPatch.getDestinationCode()));
                list = session.createQuery(query).getResultList();
                c = list.get(0);
                c.getDestination().add(flightPatch);
                session.flush();

                session.beginTransaction();
                session.save(flightPatch);
                session.getTransaction().commit();
            }
            else{
                flight.setFlight_num(flightPatch.getFlight_num());
                flight.setDepartureCode(flightPatch.getDepartureCode());
                flight.setDestinationCode(flightPatch.getDestinationCode());
                session.flush();
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.toString());
        }
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

    public static void setSession(Session session){
        flightService.session = session;
    }

}