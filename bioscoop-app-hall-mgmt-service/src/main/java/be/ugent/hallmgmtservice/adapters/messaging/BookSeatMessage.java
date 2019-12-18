package be.ugent.hallmgmtservice.adapters.messaging;

import be.ugent.hallmgmtservice.domain.Seat;

import java.util.List;

public abstract class BookSeatMessage {
    private int eventid;
    private int ticketid;
    private List<Seat> seats;

    public BookSeatMessage(){}

    public BookSeatMessage(int eventId, int ticketId, List<Seat> seats) {
        this.eventid = eventId;
        this.ticketid = ticketId;
        this.seats = seats;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public int getTicketid() {
        return ticketid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
