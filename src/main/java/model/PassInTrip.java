package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "pass_in_trip")
public class PassInTrip {
    @EmbeddedId
    private PassInTripId passInTripId;
    @Column(length = 50)
    private String place;

    public PassInTrip(PassInTripId passInTripId, String place) {
        this.passInTripId = passInTripId;
        this.place = place;
    }

    public PassInTrip() {
    }

    @Embeddable
    public static class PassInTripId implements Serializable {
        public Long tripNumber;
        public Long passengerID;
        public Date date;

        public PassInTripId(Long tripNumber, Long passengerID, Date date) {
            this.tripNumber = tripNumber;
            this.passengerID = passengerID;
            this.date = date;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PassInTripId passInTripId = (PassInTripId) o;
            return tripNumber.equals(passInTripId.tripNumber) && passengerID.equals(passInTripId.passengerID) && date.equals(passInTripId.date);
        }

        @Override
        public int hashCode() {
            return Objects.hash(tripNumber, passengerID, date);
        }
    }
}