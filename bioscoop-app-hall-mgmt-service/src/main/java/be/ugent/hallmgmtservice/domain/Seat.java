package be.ugent.hallmgmtservice.domain;

import org.springframework.data.annotation.Id;

public class Seat {

    @Id
    private String id;
    private int seatNumber;
    private int rowNumber;
    private SeatType type;
    private SeatStatus status;

    public Seat(){}

    public Seat(int seatNumber, int rowNumber, SeatType type, SeatStatus status) {
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
        this.type = type;
        this.status = status;
    }

    public Seat(int seatNumber, int rowNumber, SeatType type) {
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
        this.type = type;
        this.status = SeatStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
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
