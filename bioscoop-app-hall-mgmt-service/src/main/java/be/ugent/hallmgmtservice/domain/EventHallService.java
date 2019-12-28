package be.ugent.hallmgmtservice.domain;

import be.ugent.hallmgmtservice.HallMgmtServiceApplication;
import be.ugent.hallmgmtservice.persistence.EventHallRepository;
import be.ugent.hallmgmtservice.persistence.HallRepository;
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
    private final HallRepository hallRepository;

    @Autowired
    public EventHallService(EventHallRepository eventHallRepository, HallRepository hallRepository) {
        this.eventHallRepository = eventHallRepository;
        this.hallRepository = hallRepository;
    }


    public List<Seat> bookSeats(int eventHallId, List<Seat> requestedSeats){
        //find event
        final EventHall h = eventHallRepository.findByEventHallId(eventHallId);
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

    public List<Seat> deleteBookedSeats(int eventHallId, List<Seat> seatsToDelete){
        //find event
        final EventHall h = eventHallRepository.findByEventHallId(eventHallId);
        List<Seat> deletedSeats = new ArrayList<>();
        if(h != null) {
            for (Seat seatToDelete : seatsToDelete) {
                Optional<Seat> s = h.getSeatById(seatToDelete.getId());
                if (s.isPresent()) {
                    s.get().setStatus(SeatStatus.AVAILABLE);
                    deletedSeats.add(s.get());
                }
            }
            eventHallRepository.save(h);
            return deletedSeats;
        }
        return null;
    }

    public int reserveHall(int hallNumber, int eventId) {
        Hall hall = hallRepository.findByNumber(hallNumber);
        if(hall != null){
            EventHall newEventHall = new EventHall(hall, eventId);
            EventHall ceatedEventHall = eventHallRepository.save(newEventHall);
            return ceatedEventHall.getEventHallId();
        }else{
            logger.info("Error occured while reserving a hall: hall doesn't exist.");
            return -1;
        }
    }

    public int deleteReservedHall(int eventId) {
        EventHall hall = eventHallRepository.findByEventHallId(eventId);
        if(hall != null){
            eventHallRepository.delete(hall);
            return hall.getEventHallId();
        }else{
            return -1;
        }
    }
}
