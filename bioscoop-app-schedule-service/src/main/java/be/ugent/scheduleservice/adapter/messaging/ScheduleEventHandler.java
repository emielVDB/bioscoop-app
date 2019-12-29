package be.ugent.scheduleservice.adapter.messaging;

import be.ugent.scheduleservice.domain.Schedule;
import be.ugent.scheduleservice.domain.ScheduleWithAdTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class ScheduleEventHandler {
    private static Logger logger = LoggerFactory.getLogger(ScheduleEventHandler.class);

    @StreamListener(Channels.ADDADSLOTS_REPLY)
    public void addAdSlotsReply(ScheduleWithAdTime resp)
    {
        if(resp.getSeconds()==-1)
        {
            logger.info("failed to create a new ad slot");
        }
        else
        {
            logger.info("successfully created an ad slot");
        }
    }

    @StreamListener(Channels.BOOKHALL_REPLY)
    public void bookHallReply(Schedule s)
    {
        if(s.getZaalNmr()==-1)
        {
            logger.info("failed to book a hall");
        }
        else
        {
            logger.info("successfully booked a hall");
        }
    }


    @StreamListener(Channels.GETHALLPROP_REPLY)
    public void getHallPropReply()
    {
        logger.info("hier getHallPropReply");
    }





}

