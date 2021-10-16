package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="booking")
public class Booking {

    public Booking(){}

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticket_number")
    @Id
    private int ticket_num;

    @Column
    private int ssn;

    @Column(name="flight_number")
    private int flight_num;

    public int getTicket_num() {
        return ticket_num;
    }

    public void setTicket_num(int ticket_num) {
        this.ticket_num = ticket_num;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public int getFlight_num() {
        return flight_num;
    }

    public void setFlight_num(int flight_num) {
        this.flight_num = flight_num;
    }
}
