package be.ugent.statisticsservice.adapters;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {

    static final String TICKET_BOOKED="booking_ticket_result";

    @Input(TICKET_BOOKED)
    SubscribableChannel processTicketBooked();
}
