package be.ugent.hallmgmtservice.adapters.messaging;

import be.ugent.hallmgmtservice.domain.Seat;

import java.util.List;

public class BookSeatResponse extends BookSeatMessage {
    public BookSeatResponse(int eventid, int ticketid, List<Seat> seats){
        super(eventid, ticketid, seats);
    }
}
