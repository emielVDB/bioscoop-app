package be.ugent.ticketsservice.adapters.Messaging;

import be.ugent.ticketsservice.domain.Seat;

import java.util.List;

public class BookSeatResponse {
    private Long ticketid;
    private int eventid;
    private List<Seat> seats;

    public BookSeatResponse(Long ticketid, int eventid, List<Seat> seats) {
        this.ticketid = ticketid;
        this.eventid = eventid;
        this.seats = seats;
    }

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

    public Long getTicketid() {
        return ticketid;
    }

}
