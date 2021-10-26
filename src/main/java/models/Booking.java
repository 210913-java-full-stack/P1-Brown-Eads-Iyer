package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="booking")
public class Booking {

    //Constructor for hibernate
    public Booking() {}

    //id for booking table
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ticket_number")
    private int ticket_num;

    //Is the user on the plane?
    @Column(nullable=false)
    private boolean check_in;

    //explicit flight identifier
    @Column(nullable = false)
    private int flight_id;

    //explicit user ssn
    @Column(nullable = false)
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

    public void setTicket_num(int ticket_num) {
        this.ticket_num = ticket_num;
    }

}