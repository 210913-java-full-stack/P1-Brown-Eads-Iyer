package services;

import models.User;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class userService {
    private static Session session;

    public static User getUserBySSN(int ssn){
        return session.get(User.class, ssn);
    }

    public static void saveNewUser(User user){
        //TODO: checkout that double submit bug
        try{
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }
        catch(Exception e){
            session.getTransaction().rollback();
            System.out.println("users: Bad transaction rolled back");
        }
    }

    public static void deleteUser(User user){
        session.delete(user);
    }

    public static List<User> getAllUsers(){
        CriteriaBuilder cBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = cBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public static void setSession(Session session){
        userService.session = session;
    }

}
