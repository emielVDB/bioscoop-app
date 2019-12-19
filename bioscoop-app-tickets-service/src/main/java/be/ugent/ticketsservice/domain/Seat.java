package be.ugent.ticketsservice.domain;

import javax.persistence.*;

@Entity
public class Seat {
    @Id
    @GeneratedValue
    private long seatid;
    private int seatNumber;
    private int rowNumber;
    private long id;
    @ManyToOne
    @JoinColumn
    private Ticket ticket;

    public Seat() {
    }

    public Seat(long id) { // de creatie gebeurt enkel met seatid. Pas nadat de hall mgmt service de zetels effectief heeft geboekt worden de seat en rownumber ingevuld
        this.id=id;
        this.seatNumber=0;
        this.rowNumber=0;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public long getId() {
        return id;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", seatNumber=" + seatNumber +
                ", rowNumber=" + rowNumber +
                ", seatid=" + seatid +
                ", ticket=" + ticket +
                '}';
    }
}
