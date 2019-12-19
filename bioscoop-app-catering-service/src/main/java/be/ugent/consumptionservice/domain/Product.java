package be.ugent.consumptionservice.domain;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    private Long productid;
    private double price;
    private String name;

    public Product(){}

    public Product(Long productid, double price, String name) {
        this.productid = productid;
        this.price = price;
        this.name = name;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
