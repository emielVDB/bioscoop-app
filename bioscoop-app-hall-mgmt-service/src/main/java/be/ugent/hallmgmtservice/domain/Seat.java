package be.ugent.hallmgmtservice.domain;

import org.springframework.data.annotation.Id;

public class Seat {

    private long id;
    private int seatNumber;
    private int rowNumber;
    private SeatType type;
    private SeatStatus status;

    public Seat(){}

    public Seat(int seatNumber, int rowNumber, SeatType type, SeatStatus status) {
        this.setId(rowNumber, seatNumber);
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

    public long getId() {
        return id;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setId(int row, int seat) {
        this.id = Long.parseLong(String.format("%02d%02d", rowNumber, seatNumber));
    }
    public void setId(int row, int seat, Long eventid) {
        this.id = Long.parseLong(String.format("%02d%02d%02d", rowNumber, seatNumber, eventid));
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
