package models;

import javax.persistence.*;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_ssn", nullable=false, referencedColumnName="ssn")
    //Booking reference (foreign key) to ssn
    private List<Booking> ssnList;

    @Column(name="first_name")
    //user first name
    private String fName;

    @Column(name="last_name")
    //user last name
    private String lName;

    @Column
    //password for user
    private String password;

    public List<Booking> getSsnList() {
        return ssnList;
    }

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
}
