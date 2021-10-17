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

    public int getFlight_num() {return flight_number;}

    public void setFlight_num(int flight_number) {this.flight_number = flight_number;}
}
