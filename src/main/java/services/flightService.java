package services;

import models.Flight;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.FileLogger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Class for querying and manipulating flight table
 * @author James Brown
 */
public class flightService {
    private static Session session;
    private static FileLogger f = FileLogger.getFileLogger();

    /**
     * gets Flight session object
     * @param flightNum id for each flight
     * @return Flight object
     */
    public static Flight getFlightByFlightNum(int flightNum){
        return session.get(Flight.class, flightNum);
    }

    /**
     * save or update and persist flight object in flight table
     * @param flightPatch jsonBody from httpServletRequest
     */
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
            Transaction tx = session.beginTransaction();
            Flight flight = session.get(Flight.class, flightPatch.getFlight_number());
            if (flight == null){

                session.save(flightPatch);
                tx.commit();
            }
            else{

                session.update(flightPatch);
                tx.commit();
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            f.writeLog(e.getMessage() +
                    "\n flights: bad transaction rolled back", 1);
        }
    }

    /**
     * removes flight from table and persists
     * @param flightNum identifier for flight
     */
    public static void deleteFlight(int flightNum){
        Transaction tx = session.beginTransaction();
        try {
            Flight flight = getFlightByFlightNum(flightNum);
            session.delete(flight);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            f.writeLog(e.getMessage(), 1);
        }
    }

    /**
     * queries flight table for all information
     * @return resultList for select * from flight
     */
    public static List<Flight> getAll(){
        CriteriaBuilder cBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Flight> query = cBuilder.createQuery(Flight.class);
        Root<Flight> root = query.from(Flight.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    /**
     * sets the Session for flightService
     * @param session session created in the hibernateManager
     */
    public static void setSession(Session session){
        flightService.session = session;
    }

}