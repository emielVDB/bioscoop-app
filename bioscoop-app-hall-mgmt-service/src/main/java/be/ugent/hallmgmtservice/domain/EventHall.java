package be.ugent.hallmgmtservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "eventhall")
public class EventHall extends Hall {

    private int eventId;

    public EventHall(){}

    public EventHall(Hall hall, int eventId) {
        super(hall.getNumber(), hall.getSeats(), hall.getScreenSize(), hall.getFacilities(), hall.getTechnologies());
        this.eventId = eventId;
    }

    public int getEventId() { return eventId; }

    public void setEventId(int eventId) { this.eventId = eventId; }
}
