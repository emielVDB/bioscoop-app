package be.ugent.hallmgmtservice.adapters.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {
    static final String RESERVE_HALL = "reserve_hall";
    static final String RESERVED_HALL = "reserved_hall";

    static final String BOOK_SEATS = "book_seats";
    static final String BOOKED_SEATS = "booked_seats";

    static final String DELETE_BOOKED_SEATS = "delete_booked_seats";
    static final String BOOKED_SEATS_DELETED = "booked_seats_deleted";

    @Input(RESERVE_HALL)
    SubscribableChannel reserveHall();

    @Output(RESERVED_HALL)
    MessageChannel reservedHall();

    @Input(BOOK_SEATS)
    SubscribableChannel bookSeats();

    @Output(BOOKED_SEATS)
    MessageChannel bookedSeats();

    @Input(DELETE_BOOKED_SEATS)
    SubscribableChannel deleteBookedSeats();
}
