package model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;


@Entity
@Table(name = "trip")
public class Trip {
    @Id
    private long tripNumber;
    @Column(length = 50)
    private String plane;
    @Column(length = 50)
    private String townFrom;
    @Column(length = 50)
    private String townTo;
    @Column(length = 50)
    private Time timeOut;
    @Column(length = 50)
    private Time timeIn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany
    @JoinTable(name = "pass_in_trip", joinColumns = @JoinColumn(referencedColumnName = "tripNumber", name = "tripNumber"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id", name = "passengerID"))
    private Set<Passenger> passengers;

    public Trip(Long tripNumber, Company company, String plane, String townFrom, String townTo, Time timeOut, Time timeIn) {

        this.tripNumber = tripNumber;
        this.company = company;
        this.plane = plane;
        this.townFrom = townFrom;
        this.townTo = townTo;
        this.timeOut = timeOut;
        this.timeIn = timeIn;
    }

    public Trip() {

    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public void setTimeOut(Time timeOut) {
        this.timeOut = timeOut;
    }

    public void setTimeIn(Time timeIn) {
        this.timeIn = timeIn;
    }

    public void setTownFrom(String townFrom) {
        this.townFrom = townFrom;
    }

    public void setTownTo(String townTo) {
        this.townTo = townTo;
    }

    public void setTripNumber(long tripNumber) {
        this.tripNumber = tripNumber;
    }

    public String getPlane() {
        return plane;
    }

    public String getTownFrom() {
        return townFrom;
    }

    public String getTownTo() {
        return townTo;
    }

    public Time getTimeOut() {
        return timeOut;
    }

    public Time getTimeIn() {
        return timeIn;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripNumber=" + tripNumber +
                ", plane='" + plane + '\'' +
                ", townFrom='" + townFrom + '\'' +
                ", townTo='" + townTo + '\'' +
                ", timeOut=" + timeOut +
                ", timeIn=" + timeIn +
                '}';
    }
}