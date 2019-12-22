package be.ugent.scheduleservice.adapter.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
/*
public interface Channels {

    static final String ADDADSLOTS="AddAdSlots";
    static final String BOOKHALL="BookHall";
    static final String GETHALLPROP="GetHallProp";
    static final String GETHALLPROP_REPLY="GetHallPropReply";

    @Output(ADDADSLOTS)
    MessageChannel AddAdvertisementSlots();


    @Output(BOOKHALL)
    MessageChannel BookHall();


    @Output(GETHALLPROP)
    MessageChannel GetHallProperties();


    @Input(GETHALLPROP_REPLY)
    SubscribableChannel GetHallPropReply();
}*/


public interface Channels {
    static final String BOOK_SEATS = "book_seats";
    static final String BOOKED_SEATS = "booked_seats";
    static final String DELETE_BOOKED_SEATS = "delete_booked_seats";
    static final String BOOK_CONSUMPTIONS="book_consumptions";
    static final String BOOKED_CONSUMPTIONS="booked_consumptions";
    static final String DELETE_BOOKED_CONSUMPTIONS = "delete_booked_consumptions";
    static final String BOOKING_TICKET_RESULT = "booking_ticket_result";


    @Output(BOOK_SEATS)
    MessageChannel bookSeats();

    @Output(BOOK_CONSUMPTIONS)
    MessageChannel bookConsumptions();

    @Output(DELETE_BOOKED_CONSUMPTIONS)
    MessageChannel deleteBookedConsumptions();

    @Output(BOOKING_TICKET_RESULT)
    MessageChannel bookingTicketResult();

    @Output(DELETE_BOOKED_SEATS)
    MessageChannel deleteBookedSeats();
}
