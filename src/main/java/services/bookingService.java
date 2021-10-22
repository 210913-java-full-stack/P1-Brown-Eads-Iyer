package services;

import models.Booking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class bookingService {
    private static SessionFactory sFactory;
    private static Session session;

    public static Booking getBookingByTicketNum(int ticketNum){
        return session.get(Booking.class, ticketNum);
    }

    public static void saveNewBooking(Booking booking){
        session.save(booking);
    }

    public static void deleteBooking(Booking booking){
        session.delete(booking);
    }

    public static List<Booking> getAll(){
        CriteriaBuilder cBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Booking> query = cBuilder.createQuery(Booking.class);
        Root<Booking> root = query.from(Booking.class);
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
        bookingService.session = session;
    }
}
