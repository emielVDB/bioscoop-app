package be.ugent.statisticsservice.adapters;

import be.ugent.statisticsservice.domain.Consumption;
import be.ugent.statisticsservice.domain.Seat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookedTicket {
    private Long ticketid;
    private String name;
    private List<Seat> seats;
    private int eventid;
    private int hallnumber;
    private String event;
    private LocalDate dateEvent;
    private List<Consumption> consumptions;
    private Long purchaseid;
    private LocalDate dateBooked;
    private double price;
    private boolean booked;

    public BookedTicket(Long ticketid, String name, List<Seat> seats, int eventid, int hallnumber, String event, LocalDate dateEvent, List<Consumption> consumptions, Long purchaseid, LocalDate dateBooked, double price, boolean booked) {
        this.ticketid = ticketid;
        this.name = name;
        this.seats = seats;
        this.eventid = eventid;
        this.hallnumber = hallnumber;
        this.event = event;
        this.dateEvent = dateEvent;
        this.consumptions = consumptions;
        this.purchaseid = purchaseid;
        this.dateBooked = dateBooked;
        this.price = price;
        this.booked = booked;
    }

    public Long getTicketid() {
        return ticketid;
    }

    public void setTicketid(Long ticketid) {
        this.ticketid = ticketid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public int getHallnumber() {
        return hallnumber;
    }

    public void setHallnumber(int hallnumber) {
        this.hallnumber = hallnumber;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public LocalDate getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(LocalDate dateEvent) {
        this.dateEvent = dateEvent;
    }

    public List<Consumption> getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(List<Consumption> consumptions) {
        this.consumptions = consumptions;
    }

    public Long getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(Long purchaseid) {
        this.purchaseid = purchaseid;
    }

    public LocalDate getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(LocalDate dateBooked) {
        this.dateBooked = dateBooked;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
