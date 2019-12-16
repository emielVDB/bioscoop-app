package be.ugent.hallmgmtservice.domain;

import be.ugent.hallmgmtservice.persistence.EventHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventHallService {
    private final EventHallRepository eventHallRepository;

    @Autowired
    public EventHallService(EventHallRepository eventHallRepository){this.eventHallRepository = eventHallRepository;}

    public List<Seat> bookSeats(int eventId, List<Long> seats){
        //find event
        //find seats
        //check if seats are available
        return new ArrayList<Seat>();
    }
}
