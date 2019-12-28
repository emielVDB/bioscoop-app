package be.ugent.scheduleservice.adapter.messaging;

import be.ugent.scheduleservice.domain.Schedule;
import be.ugent.scheduleservice.domain.ScheduleWithAdTime;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessageGateway {

    @Gateway(requestChannel = Channels.ADDADSLOTS)
    public void addAdvertisementSlots(ScheduleWithAdTime scheduleWithAdTime);

    @Gateway(requestChannel = Channels.BOOKHALL)
    public void BookHall(Schedule schedule);

    @Gateway(requestChannel = Channels.GETHALLPROP)
    public void getHallProperties(Schedule schedule);

    @Gateway(requestChannel = Channels.REMOVEADSLOT)
    public void removeAdsSlot(Schedule schedule);

    @Gateway(requestChannel = Channels.REMOVEBOOKEDHALL)
    public void removeBookedHall(Schedule schedule);


}
