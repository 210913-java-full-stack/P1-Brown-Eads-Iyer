package services;

import models.Booking;
import models.Flight;
import models.User;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class bookingService {
    private static Session session;

    public static Booking getBookingByTicketNum(int ticketNum){
        return session.get(Booking.class, ticketNum);
    }

    public static void saveNewBooking(Booking bookPatch){
        try{
            //tie to flight
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Flight> query = cb.createQuery(Flight.class);
            Root<Flight> root = query.from(Flight.class);
            query.where(cb.equal(root.get("flight_number"), bookPatch.getFlight_id()));
            List<Flight> list = session.createQuery(query).getResultList();
            Flight f = list.get(0);
            f.getFlight_num().add(bookPatch);

            //tie to user
            CriteriaQuery<User> q = cb.createQuery(User.class);
            Root<User> r = q.from(User.class);
            query.where(cb.equal(r.get("ssn"), bookPatch.getSsn()));
            List<User> userList = session.createQuery(q).getResultList();
            User u = userList.get(0);
            u.getSsnList().add(bookPatch);
            session.flush();

            //figure out 1220 error
            System.out.println(bookPatch.getSsn());

            session.beginTransaction();
            session.save(bookPatch);
            session.getTransaction().commit();
        }catch(Exception e){
            //TODO: logger
            session.getTransaction().rollback();
            System.out.println("booking: bad transaction rolled back\n");
            e.printStackTrace();
        }
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

    public static void setSession(Session session){bookingService.session = session;}
}
