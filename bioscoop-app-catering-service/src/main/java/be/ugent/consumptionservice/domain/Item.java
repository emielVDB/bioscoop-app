package be.ugent.consumptionservice.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "FK_product")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "FK_purchase")
    private Purchase purchase;

    public Item(){}

    public Item(Product product, Purchase purchase) {
        this.purchase = purchase;
        this.product = product;
    }
}
