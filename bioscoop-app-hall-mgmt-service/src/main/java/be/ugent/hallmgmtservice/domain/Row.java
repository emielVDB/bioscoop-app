package be.ugent.hallmgmtservice.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Row {

    @Id
    private String id;
    private int nr;
    private List<Seat> seats;

    public Row(int nr, List<Seat> seats) {
        this.nr = nr;
        this.seats = seats;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
