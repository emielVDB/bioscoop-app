package be.ugent.consumptionservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"items"})
public class Product {

    @Id
    @JsonProperty("productid")
    private long productid;
    private double price;
    @JsonProperty("name")
    private String name;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonProperty("items")
    private List<Item> items;

    public Product(){}

    public Product(int productid, double price, String name) {
        this.productid = productid;
        this.price = price;
        this.name = name;
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
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
