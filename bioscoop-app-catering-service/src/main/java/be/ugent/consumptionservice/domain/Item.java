package be.ugent.consumptionservice.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Purchase purchase;

    public Item(){}

    public Item(Product product, Purchase purchase) {
        this.purchase = purchase;
        this.product = product;
    }
}
