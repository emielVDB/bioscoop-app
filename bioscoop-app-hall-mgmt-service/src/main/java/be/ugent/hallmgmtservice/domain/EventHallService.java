package be.ugent.hallmgmtservice.domain;

import be.ugent.hallmgmtservice.HallMgmtServiceApplication;
import be.ugent.hallmgmtservice.persistence.EventHallRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventHallService {
    Logger logger = LoggerFactory.getLogger(HallMgmtServiceApplication.class);

    private final EventHallRepository eventHallRepository;

    @Autowired
    public EventHallService(EventHallRepository eventHallRepository){this.eventHallRepository = eventHallRepository;}

    public List<Seat> bookSeats(int eventId, List<Seat> requestedSeats){
        //find event
        final EventHall h = eventHallRepository.findByEventId(eventId);
        if(h != null){
            //check if seat exists and is available
            List<Seat> availableSeats = new ArrayList<>();
            for(Seat requestedSeat : requestedSeats){
                Optional<Seat> s = h.getSeatById(requestedSeat.getId())
                                    .filter(seat -> seat.getStatus() == SeatStatus.AVAILABLE);
                s.ifPresent(availableSeats::add);
            }

            //check if each seat of the requested seats exists and is available
            if(availableSeats.size() == requestedSeats.size()){

                //update the status of the seats to booked
                for(Seat availableSeat : availableSeats){
                    logger.info("seat with id " + availableSeat.getId());
                    h.getSeatById(availableSeat.getId()).ifPresent(seat -> seat.setStatus(SeatStatus.BOOKED));
                }

                //update the booked seats in the event hall
                EventHall returnedEventHall = eventHallRepository.save(h);

                //get the booked seats and return them
                List<Seat> bookedSeats = new ArrayList<>();
                for(Seat requestedSeat : requestedSeats){
                    Optional<Seat> s = returnedEventHall.getSeatById(requestedSeat.getId());
                    s.ifPresent(bookedSeats::add);
                }
                return bookedSeats;
            }else{
                logger.info("Error occured while booking seats");
            }
        }
        return null;
    }
}
