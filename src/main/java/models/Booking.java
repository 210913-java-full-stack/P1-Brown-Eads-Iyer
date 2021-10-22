package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="booking")
public class Booking {

    public Booking() {

    }

    public Booking(int ticket_num, boolean check_in){
        this.ticket_num = ticket_num;
        this.check_in = check_in;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticket_number")
    private int ticket_num;

    @Column(nullable = false)
    private boolean check_in;

//    @Column(name="flight_number")
//    private int flight_num;


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

//    public int getFlight_num() {
//        return flight_num;
//    }
//
//    public void setFlight_num(int flight_num) {
//        this.flight_num = flight_num;
//    }
}