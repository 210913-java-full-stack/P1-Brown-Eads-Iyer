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
import java.util.List;

public class bookingService {
    private static Session session;
    private static FileLogger f = FileLogger.getFileLogger();

    public static Booking getBookingByTicketNum(int ticketNum){
        return session.get(Booking.class, ticketNum);
    }

    public static void saveNewBooking(Booking bookPatch){
        try{
            Booking book = session.get(Booking.class, bookPatch.getTicket_num());
            CriteriaBuilder cb = session.getCriteriaBuilder();
            Transaction tx;

            //tie to flight
            CriteriaQuery<Flight> flightQuery = cb.createQuery(Flight.class);
            Root<Flight> root = flightQuery.from(Flight.class);
            flightQuery.where(cb.equal(root.get("flight_number"), bookPatch.getFlight_id()));
            List<Flight> list = session.createQuery(flightQuery).getResultList();
            Flight f = session.get(Flight.class, list.get(0).getFlight_number());

            //tie to user
            CriteriaQuery<User> userQuery = cb.createQuery(User.class);
            Root<User> userRoot = userQuery.from(User.class);
            userQuery.where(cb.equal(userRoot.get("ssn"), bookPatch.getSsn()));
            List<User> userList = session.createQuery(userQuery).getResultList();
            User u = session.get(User.class, userList.get(0).getSsn());

            if (book == null){

            //tie to flight reference
            f.getFlight_num().add(bookPatch);
            //tie to user reference
            u.getSsnList().add(bookPatch);

            session.flush();

            session.beginTransaction();
            session.save(bookPatch);
            session.getTransaction().commit();
            }else {
////                //update flight reference
//                f.getFlight_num().get(bookPatch.getTicket_num()).setCheck_in(bookPatch.isCheck_in());
//                f.getFlight_num().get(bookPatch.getTicket_num()).setSsn(bookPatch.getSsn());
//                f.getFlight_num().get(bookPatch.getTicket_num()).setFlight_id(bookPatch.getFlight_id());
////                //update user reference
//                for(int i = 0; i < u.getSsnList().size(); i++){
//                    if (u.getSsnList().get(i).getTicket_num() == bookPatch.getTicket_num()){
//                        u.getSsnList().get(i).setSsn(bookPatch.getSsn());
//                        u.getSsnList().get(i).setCheck_in(bookPatch.isCheck_in());
//                        u.getSsnList().get(i).setFlight_id(bookPatch.getFlight_id());
//                        break;
//                    }
//                }
                //for some reason the user reference to booking does not update automatically
                book.setSsn(bookPatch.getSsn());
                book.setCheck_in(bookPatch.isCheck_in());
                book.setFlight_id(bookPatch.getFlight_id());

                tx = session.beginTransaction();
                session.update(book);
                tx.commit();
            }
        }catch(Exception e){
            //TODO: logger
            session.getTransaction().rollback();
            f.writeLog(e.getMessage() + "\nbooking: bad transaction rolled back", 1);
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
