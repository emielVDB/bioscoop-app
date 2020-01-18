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

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdvertisementEventHandler {
    private static Logger logger = LoggerFactory.getLogger(AdvertisementEventHandler.class);

    @Autowired
    AdvertisementSlotsRepository advertisementSlotsRepository;

    @StreamListener(Channels.ADDADSLOTS)
    @SendTo(Channels.ADDADSLOTS_REPLY)
    public ScheduleWithAdTime addAdSlots(ScheduleWithAdTime scheduleWithAdTime)
    {
        logger.info("Adding new AdvertisementSlots id:" + scheduleWithAdTime.schedule.getEventId()+"  aantalAdvertisements: "+scheduleWithAdTime.seconds);
        AdvertisementSlots slot= advertisementSlotsRepository.getAdvertisementSlotsByEventId(scheduleWithAdTime.schedule.getEventId());
        if(slot==null)
        {
            advertisementSlotsRepository.save(new AdvertisementSlots(scheduleWithAdTime.schedule.getEventId(),scheduleWithAdTime.seconds));
            return scheduleWithAdTime;
        }
        else
        {
            scheduleWithAdTime.setSeconds(-1);
            return scheduleWithAdTime;
        }
    }


    @StreamListener(Channels.REMOVEADSLOT)
    @Transactional
    public void removeAdSlot(Schedule schedule)
    {
        logger.info("Request to delete adslot with eventId: "+schedule.getEventId());

        AdvertisementSlots advertisementSlots= advertisementSlotsRepository.getAdvertisementSlotsByEventId(schedule.getEventId());
        if(advertisementSlots!=null)
        {
            advertisementSlotsRepository.removeByEventId(schedule.getEventId());
        }

    }


}

