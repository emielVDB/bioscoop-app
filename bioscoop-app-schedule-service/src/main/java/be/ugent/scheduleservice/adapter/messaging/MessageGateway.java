package be.ugent.scheduleservice.adapter.messaging;

import be.ugent.scheduleservice.domain.Schedule;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/*@MessagingGateway
public interface MessageGateway {

    @Gateway(requestChannel = Channels.ADDADSLOTS)
    public void addAdvertisementSlots(Schedule schedule);

    @Gateway(requestChannel = Channels.BOOKHALL)
    public void BookHall(Schedule schedule);

    @Gateway(requestChannel = Channels.GETHALLPROP)
    public void getHallProperties(Schedule schedule);


}*/

/*

@MessagingGateway
public interface MessageGateway {

    @Gateway(requestChannel = Channels.BOOK_SEATS)
    public void bookSeats(Schedule schedule);

    @Gateway(requestChannel = Channels.BOOK_CONSUMPTIONS)
    public void bookConsumptions(Schedule schedule);

    @Gateway(requestChannel = Channels.DELETE_BOOKED_SEATS)
    public void deleteBookedSeats(Schedule schedule);

    @Gateway(requestChannel = Channels.DELETE_BOOKED_CONSUMPTIONS)
    public void deleteBookedConsumptions(Schedule schedule);

    @Gateway(requestChannel = Channels.BOOKING_TICKET_RESULT)
    public void bookingTicketCompleted(Schedule schedule);


}*/
