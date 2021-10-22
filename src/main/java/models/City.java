package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {

    public City(){}

    public City(String code, String city, String state) {
        this.code = code;
        this.city = city;
        this.state = state;
    }

    @Id
    @Column(length=3)
    private String code;

    @Column
    private String city;

    @Column
    private String state;

    @OneToMany()
    @JoinColumn(referencedColumnName = "code", nullable = false)
    private List<Flight> departure;

    @OneToMany()
    @JoinColumn(referencedColumnName = "code", nullable = false)
    private List<Flight> destination;

    public List<Flight> getDeparture() {return departure;}

    public void setDeparture(List<Flight> departure) {this.departure = departure;}

    public List<Flight> getDestination() {return destination;}

    public void setDestination(List<Flight> destination) {this.destination = destination;}

    public String getCode() {return code;}

    public void setCode(String code) {this.code = code;}

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    public String getState() {return state;}

    public void setState(String state) {this.state = state;}
}
