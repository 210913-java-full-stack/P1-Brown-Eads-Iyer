package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
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

    @Column(nullable=false, length = 3)
    //departure code for flight
    private String departureCode;

    @Column(nullable=false, length = 3)
    //destination code for flight
    private String destinationCode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flight")
    @JsonIgnore
    //Bidirectional relationship with Booking to know who is on flight
    private List<Booking> passengers = new ArrayList<>();

    public List<Booking> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Booking> passengers) {
        this.passengers = passengers;
    }

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

//    public List<Booking> getFlight_num() {
//        return flight_num;
//    }
//
//    public void setFlight_num(List<Booking> flight_num) {
//        this.flight_num = flight_num;
//    }
//
//    public void addTicket(Booking book){
//        flight_num.add(book);
//    }
//
//    public void removeTicket(Booking book){flight_num.remove(book);}
}
