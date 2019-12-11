package be.ugent.ticketsservice.adapters;

import be.ugent.ticketsservice.domain.Ticket;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessageGateway {

    @Gateway(requestChannel = Channels.BOOK_SEATS)
    public void bookSeats(Ticket ticket);

}
