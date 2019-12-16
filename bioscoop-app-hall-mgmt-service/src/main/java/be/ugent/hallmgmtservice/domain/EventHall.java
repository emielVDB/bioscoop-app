package be.ugent.hallmgmtservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Document(collection = "eventhall")
public class EventHall extends Hall {

    private int eventId;

    public EventHall(){}

    public EventHall(Hall hall, int eventId) {
        super();
        this.eventId = eventId;
        this.setFacilities(hall.getFacilities());
        this.setNumber(hall.getNumber());
        this.setScreenSize(hall.getScreenSize());
        this.setTechnologies(hall.getTechnologies());
        List<Seat> seats = new ArrayList<>();
        for(Seat s : hall.getSeats()){
            s.setId(s.getRowNumber(), s.getSeatNumber(), eventId);
            seats.add(s);
        }
        this.setSeats(seats);
    }

    public Optional<Seat> getSeatById(long id){
        return this.getSeats().stream()
                .filter(seat -> seat.getId() == id)
                .findAny();
    }

    public int getEventId() { return eventId; }

    public void setEventId(int eventId) { this.eventId = eventId; }
}
