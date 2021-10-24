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
            Booking book = session.get(Booking.class, bookPatch.getTicket_num());

            if (book == null){
            CriteriaBuilder cb = session.getCriteriaBuilder();

            //tie to flight
            CriteriaQuery<Flight> flightQuery = cb.createQuery(Flight.class);
            Root<Flight> root = flightQuery.from(Flight.class);
            flightQuery.where(cb.equal(root.get("flight_number"), bookPatch.getFlight_id()));
            List<Flight> list = session.createQuery(flightQuery).getResultList();
            Flight f = list.get(0);
            f.getFlight_num().add(bookPatch);

            //tie to user
            CriteriaQuery<User> userQuery = cb.createQuery(User.class);
            Root<User> userRoot = userQuery.from(User.class);
            userQuery.where(cb.equal(userRoot.get("ssn"), bookPatch.getSsn()));
            List<User> userList = session.createQuery(userQuery).getResultList();
            User u = userList.get(0);
            u.getSsnList().add(bookPatch);
            session.flush();

            session.beginTransaction();
            session.save(bookPatch);
            session.getTransaction().commit();
            }else {
                book.setSsn(bookPatch.getSsn());
                book.setCheck_in(bookPatch.isCheck_in());
                book.setFlight_id(bookPatch.getFlight_id());
            }
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
