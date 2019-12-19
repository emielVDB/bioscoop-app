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
        name=null;
        price=0;
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

    @Override
    public String toString() {
        return "Consumption{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
