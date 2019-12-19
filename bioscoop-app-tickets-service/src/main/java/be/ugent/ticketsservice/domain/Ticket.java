package be.ugent.ticketsservice.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long ticketid;
    private String name;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    private List<Seat> seats;
    private int eventid;
    private int hallnumber;
    private String event;
    private LocalDate dateEvent;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    private List<Consumption> consumptions;

    private LocalDate dateBooked; //Wanneer het ticket geboekt werd
    private double price;
    private boolean booked;
    public Ticket() {
    }

    public Ticket(String name, List<Seat> seats, int hallnumber, String event,int eventid, LocalDate dateEvent, double price,List<Consumption> consumptions) {
        this.name=name;
        this.eventid=eventid;
        this.hallnumber=hallnumber;
        this.event=event;
        this.dateEvent=dateEvent;
        this.price=price;
        this.seats=seats;
        this.seats.forEach(x ->x.setTicket(this));
        this.consumptions=consumptions;
        this.consumptions.forEach(x ->x.setTicket(this));
        this.booked=false;
    }

    public void setDateBooked(LocalDate dateBooked) {
        this.dateBooked = dateBooked;
    }

    public String getName() {
        return name;
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
    public List<Consumption> getConsumptions(){return consumptions;}

    public void setConsumptions(List<Consumption> consumptions){
        this.consumptions=consumptions;
        this.consumptions.forEach(x ->x.setTicket(this));
    }

    public void setSeats(List<Seat> seats) {
        if(this.getSeats()!=null){

            for(int i=0;i<this.getSeats().size();i++) {
                    this.getSeats().get(i).setRowNumber(seats.get(i).getRowNumber());
                    this.getSeats().get(i).setSeatNumber(seats.get(i).getSeatNumber());

            }
        }
        else{
            this.seats=seats;
            this.seats.forEach(x ->x.setTicket(this));
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public int getEventid() {
        return eventid;
    }

    public Long getTicketid() {
        return ticketid;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + ticketid +
                ", name='" + name + '\'' +
                ", seats=" + seats +
                ", eventid=" + eventid +
                ", hallnumber=" + hallnumber +
                ", event='" + event + '\'' +
                ", dateEvent=" + dateEvent +
                ", consumptions=" + consumptions +
                ", dateBooked=" + dateBooked +
                ", price=" + price +
                '}';
    }
}
