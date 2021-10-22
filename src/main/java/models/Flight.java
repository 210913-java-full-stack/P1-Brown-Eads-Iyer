package models;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.List;

@Entity
@Table(name="flight")
public class Flight {

    public Flight(){}

    @Id
    @Column()
    private int flight_number;

    @OneToMany
    @JoinColumn(name = "flight_number", nullable = false)
    private List<Booking> flight_num;

    public int getFlight_number() {return flight_number;}

    public void setFlight_number(int flight_number) {this.flight_number = flight_number;}

    public List<Booking> getFlight_num() {
        return flight_num;
    }

    public void setFlight_num(List<Booking> flight_num) {
        this.flight_num = flight_num;
    }
}
