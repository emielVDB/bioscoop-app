package be.ugent.ticketsservice.domain;

import javax.persistence.*;

@Entity
public class Consumption {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn
    private Ticket ticket;
    private String name;
    private double price;

    public Consumption(){
    }
    public Consumption(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public void setTicket(Ticket ticket){
        this.ticket=ticket;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Consumption{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
