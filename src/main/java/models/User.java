package models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
/**
 * Model class for users table
 * @Author James Brown
 */
public class User {

    //no-args constructor for Hibernate
    public User(){}

    @Id
    @Column
    //id for users table/user object
    private int ssn;

    @Column(name="first_name")
    //user first name
    private String fName;

    @Column(name="last_name")
    //user last name
    private String lName;

    @Column(nullable = false)
    //password for user
    private String password;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Booking> ticketList = new ArrayList<>();
//
//    public List<Booking> getTicketList() {
//        return ticketList;
//    }
//
//    public void setTicketList(List<Booking> ticketList) {
//        this.ticketList = ticketList;
//    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

//    public List<Booking> getSsnList() {
//        return ssnList;
//    }
//
//    public void setSsnList(List<Booking> ssnList) {
//        this.ssnList = ssnList;
//    }
//    public void addToTickets(Booking book){
//        ssnList.add(book);
//    }
//
//    public void removeTicket(Booking book){
//        ssnList.remove(book);
//    }
}

