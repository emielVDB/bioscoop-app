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
    @OneToMany(mappedBy = "purchase",cascade = CascadeType.ALL)
    private List<Item> items;

    public Purchase(){}

    public Purchase(List<Item> items) {
        this.purchaseid = purchaseid;
        this.items = items;
    }

    public Long getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(Long purchaseid) {
        this.purchaseid = purchaseid;
    }

    public List<Item> getProducts() {
        return items;
    }

    public void setProducts(List<Item> products) {
        this.items = items;
    }
}
