package be.ugent.hallmgmtservice.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Document(collection = "eventhall")
public class EventHall extends Hall {
    private int eventHallId;

    public EventHall(){}

    public EventHall(Hall hall, int eventId) {
        super();
        this.eventHallId = eventId;
        this.setFacilities(hall.getFacilities());
        this.setNumber(hall.getNumber());
        this.setScreenSize(hall.getScreenSize());
        this.setTechnologies(hall.getTechnologies());
        List<Seat> seats = new ArrayList<>();
        for(Seat s : hall.getSeats()){
            s.setId(s.getRowNumber(), s.getSeatNumber(), this.eventHallId);
            seats.add(s);
        }
        this.setSeats(seats);
    }

    public Optional<Seat> getSeatById(long id){
        return this.getSeats().stream()
                .filter(seat -> seat.getId() == id)
                .findAny();
    }

    public int getEventHallId() { return eventHallId; }

    private void setEventHallId(int eventId) {
        this.eventHallId = eventId;
//        SimpleDateFormat formatter= new SimpleDateFormat("ddMMyyss");
//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(formatter.format(date));
//        this.eventHallId = Long.parseLong(String.format("%s%02d", formatter.format(date), hallNumber));
    }
}
