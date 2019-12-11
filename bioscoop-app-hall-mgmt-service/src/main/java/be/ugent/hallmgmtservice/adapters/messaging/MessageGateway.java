package be.ugent.hallmgmtservice.adapters.messaging;

import be.ugent.hallmgmtservice.domain.EventHall;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessageGateway {

    @Gateway(requestChannel = Channels.RESERVED_HALL)
    public void reserveHallCompleted(EventHall eventHall);

    @Gateway(requestChannel = Channels.BOOKED_SEATS)
    public void bookSeatsCompleted(EventHall eventHall);
}
