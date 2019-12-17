package be.ugent.hallmgmtservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Document(collection = "eventhall")
public class EventHall extends Hall {
    //id exists of the day + month + year + seconds when the eventhall is created + hallnumber
    //ddMMyysshallnumber
    private Long eventId;

    public EventHall(){}

    public EventHall(Hall hall) {
        super();
        this.setEventId(hall.getNumber());
        this.setFacilities(hall.getFacilities());
        this.setNumber(hall.getNumber());
        this.setScreenSize(hall.getScreenSize());
        this.setTechnologies(hall.getTechnologies());
        List<Seat> seats = new ArrayList<>();
        for(Seat s : hall.getSeats()){
            s.setId(s.getRowNumber(), s.getSeatNumber(), this.eventId);
            seats.add(s);
        }
        this.setSeats(seats);
    }

    public Optional<Seat> getSeatById(long id){
        return this.getSeats().stream()
                .filter(seat -> seat.getId() == id)
                .findAny();
    }

    public Long getEventId() { return eventId; }

    public void setEventId(int hallNumber) {
        SimpleDateFormat formatter= new SimpleDateFormat("ddMMyyss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        this.eventId = Long.parseLong(String.format("%s%02d", formatter.format(date), hallNumber));
    }
}
