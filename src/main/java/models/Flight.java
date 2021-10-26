package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="flight")
public class Flight {

    public Flight(){}

    @Id
    @Column()
    private int flight_number;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="flight_number", nullable=false)
    private List<Booking> flight_num;

    @Column(nullable=false)
    private String departureCode;

    @Column(nullable=false)
    private String destinationCode;

    public String getDepartureCode() {
        return departureCode;
    }

    public void setDepartureCode(String departureCode) {
        this.departureCode = departureCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public int getFlight_number() {return flight_number;}

    public void setFlight_number(int flight_number) {this.flight_number = flight_number;}

    public List<Booking> getFlight_num() {
        return flight_num;
    }

    public void setFlight_num(List<Booking> flight_num) {
        this.flight_num = flight_num;
    }
}