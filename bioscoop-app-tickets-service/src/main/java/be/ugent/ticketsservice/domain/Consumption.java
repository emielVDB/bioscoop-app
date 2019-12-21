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
    private Long productid;

    public Consumption(){
    }
    public Consumption(String name, double price,Long productid) {
        this.name = name;
        this.price = price;
        this.productid=productid;
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

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    @Override
    public String toString() {
        return "Consumption{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", productid=" + productid +
                '}';
    }
}
