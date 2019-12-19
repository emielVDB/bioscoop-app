package be.ugent.consumptionservice.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long purchaseid;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Product> products;

    public Purchase(){}

    public Purchase(Long purchaseid, List<Product> products) {
        this.purchaseid = purchaseid;
        this.products = products;
    }

    public Long getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(Long purchaseid) {
        this.purchaseid = purchaseid;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
