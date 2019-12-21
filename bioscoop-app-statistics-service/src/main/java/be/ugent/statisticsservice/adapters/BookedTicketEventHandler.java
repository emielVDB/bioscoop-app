package be.ugent.statisticsservice.adapters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class BookedTicketEventHandler {
    private static Logger logger = LoggerFactory.getLogger(BookedTicketEventHandler.class);

    @StreamListener(Channels.TICKET_BOOKED)
    public void processBookedTicket(BookedTicket bookedTicket){
        logger.info("Process a booked ticket with id : " + bookedTicket.getTicketid());
        //Hier wordt dan mapreduce job uitgevoerd na x aantal tickets
    }
}
