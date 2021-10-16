package models;

import javax.persistence.*;

@Entity
@Table(name="flight")
public class Flight {

    public Flight(){}

    @Id
    @Column(name = "flight_number")
    private int flight_num;

    @Column
    private String departure;

    @Column
    private String destination;

    public int getFlight_num() {return flight_num;}

    public void setFlight_num(int flight_num) {this.flight_num = flight_num;}
}
