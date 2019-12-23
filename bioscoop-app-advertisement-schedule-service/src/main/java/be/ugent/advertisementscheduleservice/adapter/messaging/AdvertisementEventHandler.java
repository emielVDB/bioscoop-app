package be.ugent.advertisementscheduleservice.adapter.messaging;

import be.ugent.advertisementscheduleservice.adapter.AdvertisementRestController;
import be.ugent.advertisementscheduleservice.domain.AdvertisementSlots;
import be.ugent.advertisementscheduleservice.persistence.AdvertisementSlotsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementEventHandler {
    private static Logger logger = LoggerFactory.getLogger(AdvertisementEventHandler.class);

    @Autowired
    AdvertisementSlotsRepository advertisementSlotsRepository;

    @StreamListener(Channels.ADDADSLOTS)
    @SendTo(Channels.ADDADSLOTS_REPLY)
    public int addAdSlots(Schedule schedule,int seconds)
    {
        logger.info("Adding new AdvertisementSlots id:" + schedule.getEventId()+"  seconds: "+seconds);
        advertisementSlotsRepository.save(new AdvertisementSlots(schedule.getEventId(),seconds));

        return -1;
    }



}
