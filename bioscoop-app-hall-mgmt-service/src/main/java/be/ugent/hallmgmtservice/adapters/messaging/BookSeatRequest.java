package be.ugent.hallmgmtservice.adapters.messaging;


import be.ugent.hallmgmtservice.domain.Seat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookSeatRequest {
    private int eventid;
    private List<Seat> seats;

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
