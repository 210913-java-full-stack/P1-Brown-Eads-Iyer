package models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="cities")
/**
 * Model class for cities table
 * @Author James Brown
 */
public class City {

    //constructor for Hibernate
    public City(){}

    @Id
    @Column(length=3)
    //id for cities table
    private String code;

    @Column
    //name of city
    private String city;

    @Column
    //name of city's state
    private String state;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(referencedColumnName="code", nullable=false)
    //OneToMany relationship for departure reference in Flight
    private List<Flight> departure;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(referencedColumnName="code", nullable=false)
    //OneToMany relationship for destination reference in Flight
    private List<Flight> destination;

    public List<Flight> getDeparture() {return departure;}

    public List<Flight> getDestination() {return destination;}

    public String getCode() {return code;}

    public void setCode(String code) {this.code = code;}

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    public String getState() {return state;}

    public void setState(String state) {this.state = state;}
}