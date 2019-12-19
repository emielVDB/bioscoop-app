package be.ugent.ticketsservice.adapters.Messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {
    static final String BOOK_SEATS = "book_seats";
    static final String BOOKED_SEATS = "booked_seats";

    static final String BOOKING_TICKET_RESULT = "booking_ticket_result";

    @Output(BOOK_SEATS)
    MessageChannel bookSeats();

    @Output(BOOKING_TICKET_RESULT)
    MessageChannel bookingTicketResult();

    @Input(BOOKED_SEATS)
    SubscribableChannel processBookedSeats();

}
