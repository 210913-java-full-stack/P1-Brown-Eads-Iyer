package models;

import javax.persistence.*;

@Entity
@Table(name="booking")
/**
 * Model class for Booking aka Ticket
 * @author James Brown
 */
public class Booking {

    //Constructor for Hibernate
    public Booking() {}

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ticket_number")
    //id for booking table
    private int ticket_num;

    @Column(nullable=false)
    //Is the user on the plane?
    private boolean check_in;

    @Column(nullable = false)
    //explicit flight identifier
    private int flight_id;

    @Column(nullable = false)
    //explicit user ssn
    private int ssn_book;

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public int getSsn() {
        return ssn_book;
    }

    public void setSsn(int ssn) {
        this.ssn_book = ssn;
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

}