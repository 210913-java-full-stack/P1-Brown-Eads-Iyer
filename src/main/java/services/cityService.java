package services;

import models.City;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class cityService {
    private static Session session;

    public static City getCityByCode(String code){
        return session.get(City.class, code);
    }

    public static void saveNewCity(City patchInfo){
        //TODO: checkout that double submit bug
        try{
            City city = session.get(City.class, patchInfo.getCode());
            if(city == null) {
                Transaction tx = session.beginTransaction();
                session.save(patchInfo);
                tx.commit();
            } else {
                city.setCity(patchInfo.getCity());
                city.setCode(patchInfo.getCode());
                city.setState(patchInfo.getState());
                session.flush();
            }



//            if(session.contains(patchInfo)){
//                City c = session.get(City.class, patchInfo.getCode());
//                c.setCity(patchInfo.getCity());
//                c.setCode(patchInfo.getCode());
//                c.setState(patchInfo.getState());
//                session.flush();
//            } else {
//                session.beginTransaction();
//                session.save(patchInfo);
//                session.getTransaction().commit();
//            }
        }
        catch(Exception e){
            e.printStackTrace();
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

    public static void closeSession(){session.close();}

}