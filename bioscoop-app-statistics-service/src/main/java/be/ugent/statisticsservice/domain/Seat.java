package be.ugent.statisticsservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Seat {
    private long seatid;
    private int seatNumber;
    private int rowNumber;
    private long id;

    public Seat(long seatid, int seatNumber, int rowNumber, long id) {
        this.seatid = seatid;
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
        this.id = id;
    }

    public long getSeatid() {
        return seatid;
    }

    public void setSeatid(long seatid) {
        this.seatid = seatid;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
