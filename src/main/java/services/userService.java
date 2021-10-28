package services;

import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.FileLogger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * class for querying and manipulating user table
 * @author James Brown
 */
public class userService {
    private static Session session;
    private static FileLogger f = FileLogger.getFileLogger();

    /**
     * gets User session object
     * @param ssn id for each user
     * @return User object
     */
    public static User getUserBySSN(int ssn){
        return session.get(User.class, ssn);
    }

    /**
     * saves or updates and persists a User to user table
     * @param userPatch jsonBody from http request
     */
    public static void saveNewUser(User userPatch){
        try{
            Transaction t = session.beginTransaction();
            User u = getUserBySSN(userPatch.getSsn());
            if(u == null){
                session.save(userPatch);
                t.commit();
            } else {

                u.setfName(userPatch.getfName());
                u.setlName(userPatch.getlName());
                u.setSsn(userPatch.getSsn());
                u.setPassword(userPatch.getPassword());
                session.update(u);
                t.commit();
            }
        }
        catch(Exception e){
            //TODO logger
            session.getTransaction().rollback();
            f.writeLog(e.getMessage() +
                    "users: Bad transaction rolled back", 1);
        }
    }

    /**
     * removes entry based on user param
     * @param user jsonBody from httpServletRequest
     */
    public static void deleteUser(User user){
        session.delete(user);
    }

    /**
     * gets a list of all Users
     * @return resultlist of select * from users
     */
    public static List<User> getAllUsers(){
        CriteriaBuilder cBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = cBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    /**
     * sets the Session for userService
     * @param session session created in the hibernateManager
     */
    public static void setSession(Session session){
        userService.session = session;
    }
}
