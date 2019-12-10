package be.ugent.hallmgmtservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;

@Document //MongoDB
public class Hall {

    @Id
    private String id;
    private int number;
    private List<Seat> seats;
    private String screenSize;
    private int capacity;
    private List<String> facilities;
    private List<String> technologies;

    public Hall(){}

    public Hall(int number, List<Seat> seats, String screenSize, List<String> facilities, List<String> technologies) {
        this.number = number;
        this.seats = seats;
        this.capacity = seats.size();
        this.screenSize = screenSize;
        this.facilities = facilities;
        this.technologies = technologies;
    }

    public Hall(int number, List<Seat> seats, String screenSize){
        this.number = number;
        this.seats = seats;
        this.capacity = seats.size();
        this.screenSize = screenSize;
        this.facilities = Arrays.asList("toegankelijk voor andersvaliden", "test");
        this.technologies = Arrays.asList("Dolby 5.1", "HFR");
    }

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    public Object orElse(Object o) {
        return o;
    }
}

