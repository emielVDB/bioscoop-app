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
            logger.info("Seats booked for eventid " + request.getEventid());
            bookedSeats.forEach(s -> logger.info("{} {}", "\tseatid:", s.getId()));
            return new BookSeatResponse(request.getEventid(), request.getTicketid(), bookedSeats);
        }else{
            return new BookSeatResponse(request.getEventid(), request.getTicketid(), null);
        }
    }

    @StreamListener(Channels.RESERVE_HALL)
    @SendTo(Channels.RESERVED_HALL)
    public int reserveHall(ReserveHallRequest request){
        logger.info("received request for reserving hall number " + request.getHallNumber());
        return eventHallService.reserveHall(request.getHallNumber(), request.getEventId());
    }

    @StreamListener(Channels.DELETE_BOOKED_SEATS)
    public void deleteBookedSeats(DeleteBookedSeatRequest request){
        logger.info("received request for deleting booked seats for eventid " + request.getEventid());
        List<Seat> deletedSeats = eventHallService.deleteBookedSeats(request.getEventid(), request.getSeats());
        if(deletedSeats != null){
            logger.info("booked seats to delete for eventid" + request.getEventid());
            deletedSeats.forEach(s -> logger.info("{} {}", "\tseatid:", s.getId()));
        }else{
            logger.info("There were no seats deleted");
        }
    }
}
