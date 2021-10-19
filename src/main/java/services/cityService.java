package services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import repos.cityRepo;
import models.City;
import utils.ConnectionManager;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class cityService {
    private static SessionFactory sFactory;
    private static Session session;

    public static City getCityByCode(String code){
        return session.get(City.class, code);
    }

    public static void saveNewCity(City city){
        session.save(city);
    }

    public static void deleteCity(City city){
        session.delete(city);
    }

    public static List<City> getAll(){
        CriteriaBuilder cBuilder = session.getCriteriaBuilder();
        CriteriaQuery<City> query = cBuilder.createQuery(City.class);
        Root<City> root = query.from(City.class);
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
        cityService.session = session;
    }

}
