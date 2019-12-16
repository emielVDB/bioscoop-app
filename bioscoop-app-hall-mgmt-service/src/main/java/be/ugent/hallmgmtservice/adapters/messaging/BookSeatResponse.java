package be.ugent.hallmgmtservice.adapters.messaging;

import be.ugent.hallmgmtservice.domain.Seat;

import java.util.List;

public class BookSeatResponse {
    private int eventId;
    private List<Seat> seats;

    public BookSeatResponse(int eventId, List<Seat> seats) {
        this.eventId = eventId;
        this.seats = seats;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
