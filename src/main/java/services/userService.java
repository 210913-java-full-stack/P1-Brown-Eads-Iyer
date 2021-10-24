package services;

import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class userService {
    private static Session session;

    public static User getUserBySSN(int ssn){
        return session.get(User.class, ssn);
    }

    public static void saveNewUser(User userPatch){
        try{
            User u = session.get(User.class, userPatch.getSsn());
            if(u == null){
                Transaction t = session.beginTransaction();
                session.save(userPatch);
                t.commit();
            } else {
                u.setfName(userPatch.getfName());
                u.setlName(userPatch.getlName());
                u.setSsn(userPatch.getSsn());
                u.setPassword(userPatch.getPassword());
                session.flush();
            }
        }
        catch(Exception e){
            //logger
            session.getTransaction().rollback();
            System.out.println("users: Bad transaction rolled back");
        }
    }

    public static void deleteUser(User user){
        session.delete(user);
    }

    /**
     *
     * @return a ResultList that contains a list of all Users
     */
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
