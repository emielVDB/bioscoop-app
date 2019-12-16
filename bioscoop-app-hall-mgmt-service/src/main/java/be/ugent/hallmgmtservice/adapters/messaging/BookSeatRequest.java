package be.ugent.hallmgmtservice.adapters.messaging;


import be.ugent.hallmgmtservice.domain.Seat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class BookSeatRequest {
    private int eventId;
    private List<Long> seats;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public List<Long> getSeats() {
        return seats;
    }

    public void setSeats(List<Long> seats) {
        this.seats = seats;
    }
}
