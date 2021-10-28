package services;

import models.Booking;
import models.Flight;
import models.User;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.FileLogger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

/**
 * Class for querying and manipulating booking entries
 * @author James Brown
 */
public class bookingService {
    private static Session session;
    private static FileLogger f = FileLogger.getFileLogger();

    /**
     * returns Booking session object
     * @param ticketNum id for booking entry
     */
    public static Booking getBookingByTicketNum(int ticketNum){
        return session.get(Booking.class, ticketNum);
    }

    /**
     * Saves or update and persists a Booking object
     * @param bookPatch jsonBody from servlet
     */
    public static void saveNewBooking(Booking bookPatch){
        try{
            Transaction tx = session.beginTransaction();
            Booking book = getBookingByTicketNum(bookPatch.getTicket_num());
            if (book == null){
                session.save(bookPatch);
                tx.commit();
            }else {
                book.setCheck_in(true);
                session.update(book);
                tx.commit();
            }
        }catch(Exception e){
            //TODO: logger
            session.getTransaction().rollback();
            f.writeLog(e.getMessage() + "\nbooking: bad transaction rolled back", 1);
        }
    }

    /**
     * deletes booking entry from table
     * @param ticket_num
     */
    public static void deleteBooking(int ticket_num){
        Transaction tx = session.beginTransaction();
        Booking book = getBookingByTicketNum(ticket_num);
        session.delete(book);
        tx.commit();
    }

    /**
     * Returns resultList containing all data from booking
     * @return select * from booking
     */
    public static List<Booking> getAll(){
        CriteriaBuilder cBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Booking> query = cBuilder.createQuery(Booking.class);
        Root<Booking> root = query.from(Booking.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    /**
     * sets the Session for bookingService
     * @param session session created in the hibernateManager
     */
    public static void setSession(Session session){bookingService.session = session;}
}
