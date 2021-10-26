package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="flight")
/**
 * Model class for flight table
 * @Author James Brown
 * */
public class Flight {

    //No-args constructor for Hibernate
    public Flight(){}

    @Id
    @Column()
    //id for each flight
    private int flight_number;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="flight_number", nullable=false, referencedColumnName = "flight_number")
    //Booking reference to flight
    private List<Booking> flight_num;

    @Column(nullable=false)
    //departure code for flight
    private String departureCode;

    @Column(nullable=false)
    //destination code for flight
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
