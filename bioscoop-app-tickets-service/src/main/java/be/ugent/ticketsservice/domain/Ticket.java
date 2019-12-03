package be.ugent.ticketsservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Ticket {

    // allereerst wordt er een createTicket uitgestuurd met de eventdetails en daarna worden de zetels opgevraagd die nog beschikbaar zijn en dan
    // wordt het ticket geboekt
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int seatsNumber;
    private int hallnumber;
    private String event;
    private LocalDate dateEvent;

    private LocalDate dateBooked; //Wanneer het ticket geboekt werd
    private double price;

    public Ticket() {
    }

    public Ticket(String name, int seatsNumber, int hallnumber, String event, LocalDate dateEvent, double price) {
        this.name=name;
        this.seatsNumber=seatsNumber;
        this.hallnumber=hallnumber;
        this.event=event;
        this.dateEvent=dateEvent;
        this.price=price;
    }

    public void setDateBooked(LocalDate dateBooked) {
        this.dateBooked = dateBooked;
    }

    public String getName() {
        return name;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public int getHallnumber() {
        return hallnumber;
    }

    public String getEvent() {
        return event;
    }

    public LocalDate getDateEvent() {
        return dateEvent;
    }

    public LocalDate getDateBooked() {
        return dateBooked;
    }

    public double getPrice() {
        return price;
    }
}
