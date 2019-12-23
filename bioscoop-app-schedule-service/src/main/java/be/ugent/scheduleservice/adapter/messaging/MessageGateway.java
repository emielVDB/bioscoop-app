package be.ugent.scheduleservice.adapter.messaging;

import be.ugent.scheduleservice.domain.Schedule;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessageGateway {

    @Gateway(requestChannel = Channels.ADDADSLOTS)
    public void addAdvertisementSlots(Schedule schedule,int seconds);

    @Gateway(requestChannel = Channels.BOOKHALL)
    public void BookHall(Schedule schedule);

    @Gateway(requestChannel = Channels.GETHALLPROP)
    public void getHallProperties(Schedule schedule);


}
