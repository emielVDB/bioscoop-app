package be.ugent.scheduleservice.adapter.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class ScheduleEventHandler {
    private static Logger logger = LoggerFactory.getLogger(ScheduleEventHandler.class);

    @StreamListener(Channels.ADDADSLOTS_REPLY)
    public void addAdSlotsReply(int resp)
    {
        logger.info("hier addAdSlotsReply "+resp);
    }

    @StreamListener(Channels.BOOKHALL_REPLY)
    public void bookHallReply()
    {
        logger.info("hier bookHallReply");
    }


    @StreamListener(Channels.GETHALLPROP_REPLY)
    public void getHallPropReply()
    {
        logger.info("hier getHallPropReply");
    }





}

