package models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="booking")
/**
 * Model class for Booking aka Ticket
 * @author James Brown
 */
public class Booking {

    //no-args constructor for Hibernate
    public Booking() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    //id for booking table
    private int ticket_num;

    @Column(nullable=false)
    //Is the user on the plane?
    private boolean check_in;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "flightNumber")
    //YOU NEED ON DELETE (ELABORATE)
    private Flight flight;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setSsn(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isCheck_in() {
        return check_in;
    }

    public void setCheck_in(boolean check_in) {
        this.check_in = check_in;
    }

    public int getTicket_num() {
        return ticket_num;
    }

    public void setTicket_num(int ticket_num) {
        this.ticket_num = ticket_num;
    }
}