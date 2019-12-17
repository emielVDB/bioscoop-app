package be.ugent.hallmgmtservice.adapters;

import be.ugent.hallmgmtservice.domain.EventHall;
import be.ugent.hallmgmtservice.persistence.EventHallRepository;
import be.ugent.hallmgmtservice.persistence.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("eventhall")
public class EventHallRestController {
    private final EventHallRepository eventHallRepository;

    @Autowired
    public EventHallRestController(EventHallRepository eventHallRepository) {
        this.eventHallRepository = eventHallRepository;
    }

    @GetMapping
    public Iterable<EventHall> getAllEventHalls(){
        return this.eventHallRepository.findAll();
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventHall> getEventHall(@PathVariable("eventId") int eventId){
        EventHall hall = this.eventHallRepository.findByEventId(eventId);
        if(hall == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hall, HttpStatus.OK);
    }
}