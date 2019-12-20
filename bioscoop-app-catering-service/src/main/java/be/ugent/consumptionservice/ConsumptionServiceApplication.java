package be.ugent.consumptionservice;

import be.ugent.consumptionservice.domain.Item;
import be.ugent.consumptionservice.domain.Product;
import be.ugent.consumptionservice.domain.Purchase;
import be.ugent.consumptionservice.persistence.ItemRepository;
import be.ugent.consumptionservice.persistence.ProductRepository;
import be.ugent.consumptionservice.persistence.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
//@EnableBinding(Channels.class)
public class ConsumptionServiceApplication {
    Logger logger = LoggerFactory.getLogger(ConsumptionServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumptionServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner addProducts(ProductRepository productRepository){
        return(args -> {
            List<Product> producten = new ArrayList<>();
            producten.add(new Product(1L, 3.5, "cola"));
            producten.add(new Product(2L, 3.5, "fanta"));
            producten.add(new Product(3L, 5.22, "popcorn"));
            producten.add(new Product(4L, 2.0, "ijs"));
            for(Product p : producten){
                productRepository.save(p);
            }
        });
    }

    @Bean
    public CommandLineRunner addPurchase(PurchaseRepository purchaseRepository,
                                         ProductRepository productRepository,
                                         ItemRepository itemRepository){
        return(args -> {
            List<Item> items = new ArrayList<>();
            Purchase purchase = new Purchase();
            purchase = purchaseRepository.save(purchase);
            for(Long i = 1L; i <= 4L; i++){
                Product p = productRepository.findById(i).get();
                Item item = new Item(p, purchase);
                logger.info("product " + p.getName());
                itemRepository.save(item);
                items.add(item);
            }
            purchase.setProducts(items);
            purchaseRepository.save(purchase);
        });
    }
}
