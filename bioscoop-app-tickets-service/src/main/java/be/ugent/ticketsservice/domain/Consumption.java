package be.ugent.ticketsservice.domain;

public class Consumption {

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
}
