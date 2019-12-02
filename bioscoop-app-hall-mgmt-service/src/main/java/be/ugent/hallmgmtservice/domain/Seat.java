package be.ugent.hallmgmtservice.domain;

import org.springframework.data.annotation.Id;

public class Seat {

    @Id
    private String id;
    private int nr;
    private SeatType type;
    private SeatStatus status;

    public Seat(){}

    public Seat(int nr, SeatType type, SeatStatus status) {
        this.nr = nr;
        this.type = type;
        this.status = status;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
