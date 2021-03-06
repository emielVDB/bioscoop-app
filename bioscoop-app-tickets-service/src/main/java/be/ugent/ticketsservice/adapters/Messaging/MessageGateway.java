package be.ugent.ticketsservice.adapters.Messaging;

import be.ugent.ticketsservice.domain.Ticket;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessageGateway {

    @Gateway(requestChannel = Channels.BOOK_SEATS)
    public void bookSeats(Ticket ticket);

    @Gateway(requestChannel = Channels.BOOK_CONSUMPTIONS)
    public void bookConsumptions(Ticket ticket);

    @Gateway(requestChannel = Channels.DELETE_BOOKED_SEATS)
    public void deleteBookedSeats(Ticket ticket);

    @Gateway(requestChannel = Channels.DELETE_BOOKED_CONSUMPTIONS)
    public void deleteBookedConsumptions(Ticket ticket);

    @Gateway(requestChannel = Channels.BOOKING_TICKET_RESULT)
    public void bookingTicketCompleted(Ticket ticket);


}
