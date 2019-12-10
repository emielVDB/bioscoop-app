package be.ugent.hallmgmtservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;

@Document //MongoDB
public class Hall {

    @Id
    private String id;
    private String name;
    private List<Seat> seats;
    private String screenSize;
    private int capacity;
    private List<String> facilities;
    private List<String> technologies;

    public Hall(String name, List<Seat> seats, String screenSize, List<String> facilities, List<String> technologies) {
        this.name = name;
        this.seats = seats;
        this.capacity = seats.size();
        this.screenSize = screenSize;
        this.facilities = facilities;
        this.technologies = technologies;
    }

    public Hall(String name, List<Seat> seats, String screenSize){
        this.name = name;
        this.seats = seats;
        this.capacity = seats.size();
        this.screenSize = screenSize;
        this.facilities = Arrays.asList("toegankelijk voor andersvaliden", "test");
        this.technologies = Arrays.asList("Dolby 5.1", "HFR");
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
}

