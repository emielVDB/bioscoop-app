package be.ugent.hallmgmtservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

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

    public int getEventId() { return eventId; }

    public void setEventId(int eventId) { this.eventId = eventId; }
}
