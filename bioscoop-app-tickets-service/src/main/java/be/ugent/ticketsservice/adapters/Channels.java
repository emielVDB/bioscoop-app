package be.ugent.ticketsservice.adapters;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
public interface Channels {
    static final String BOOK_SEATS = "book_seats";
    static final String SEATS_BOOKED = "seats_booked";

    static final String BOOKING_TICKET_RESULT = "booking_ticket_result";

    @Output(BOOK_SEATS)
    MessageChannel bookSeats();

    @Output(BOOKING_TICKET_RESULT)
    MessageChannel bookingTicketResult();

}
