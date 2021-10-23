package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    public User(){}

    @Id
    @Column
    private int ssn;

    @OneToMany()
    @JoinColumn(name="user_ssn", nullable=false, referencedColumnName="ssn")
    private List<Booking> ssnList;

    @Column(name="first_name")
    private String fName;

    @Column(name="last_name")
    private String lName;

    @Column
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
