package models;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {

    public City(){}

    @Id @Column
    private String code;

    @Column
    private String city;

    @Column
    private String state;

    public String getCode() {return code;}

    public void setCode(String code) {this.code = code;}

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    public String getState() {return state;}

    public void setState(String state) {this.state = state;}
}
