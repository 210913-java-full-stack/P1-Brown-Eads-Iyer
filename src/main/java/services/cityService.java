package services;

import models.City;

import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class cityService {
    private static Session session;

    public static City getCityByCode(String code){
        return session.get(City.class, code);
    }

    public static void saveNewCity(City city){
        //TODO: checkout that double submit bug
        try{
            session.beginTransaction();
            session.saveOrUpdate(city);
            session.getTransaction().commit();
        }
        catch(Exception e){
            session.getTransaction().rollback();
            System.out.println("cities: Bad transaction rolled back");
        }
    }

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

    public static void setSession(Session session){
        cityService.session = session;
    }

}