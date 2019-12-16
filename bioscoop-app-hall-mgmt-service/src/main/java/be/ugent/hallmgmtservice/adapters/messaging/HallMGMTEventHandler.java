package be.ugent.hallmgmtservice.adapters.messaging;

import be.ugent.hallmgmtservice.HallMgmtServiceApplication;
import be.ugent.hallmgmtservice.domain.EventHallService;
import be.ugent.hallmgmtservice.domain.Seat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallMGMTEventHandler {
    Logger logger = LoggerFactory.getLogger(HallMgmtServiceApplication.class);

    private final EventHallService eventHallService;

    @Autowired
    public HallMGMTEventHandler(EventHallService eventHallService){this.eventHallService = eventHallService;}

    @StreamListener(Channels.BOOK_SEATS)
    @SendTo(Channels.BOOKED_SEATS)
    public BookSeatResponse bookSeat(BookSeatRequest request){
        logger.info("received request for booking seats for eventid " + request.getEventid());
        List<Seat> bookedSeats = eventHallService.bookSeats(request.getEventid(), request.getSeats());
        if(bookedSeats != null){
            return new BookSeatResponse(request.getEventid(), bookedSeats);
        }else{
            return new BookSeatResponse(request.getEventid(), null);
        }
    }
}
