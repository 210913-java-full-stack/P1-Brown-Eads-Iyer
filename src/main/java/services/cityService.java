package services;

import models.City;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.FileLogger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Class for manipulating and querying city table
 * @author James Brown
 */
public class cityService {
    private static Session session;
    private static FileLogger f = FileLogger.getFileLogger();

    public static City getCityByCode(String code){return session.get(City.class, code);}

    /**
     * saves or updates and persists city entry
     * @param cityPatch jsonBody from http request
     */
    public static void saveNewCity(City cityPatch){
        try{
            City city = session.get(City.class, cityPatch.getCode());
            if(city == null) {
                Transaction tx = session.beginTransaction();
                session.save(cityPatch);
                tx.commit();
            } else {
                city.setCity(cityPatch.getCity());
                city.setCode(cityPatch.getCode());
                city.setState(cityPatch.getState());
                session.flush();
            }
        }
        catch(Exception e){
            //TODO dont forget to set up logger
            session.getTransaction().rollback();
            f.writeLog(e.getMessage() +
                    "\ncities: Bad transaction rolled back", 0);
        }
    }

    /**
     * Removes a specified flight entry
     * @param city jsonBody from servlet request
     */
    public static void deleteCity(City city){
        session.delete(city);
    }

    public static List<City> getAllCities(){
        CriteriaBuilder cBuilder = session.getCriteriaBuilder();
        CriteriaQuery<City> query = cBuilder.createQuery(City.class);
        Root<City> root = query.from(City.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    /**
     * sets the Session for cityService
     * @param session session created in the hibernateManager
     */
    public static void setSession(Session session){
        cityService.session = session;
    }

}