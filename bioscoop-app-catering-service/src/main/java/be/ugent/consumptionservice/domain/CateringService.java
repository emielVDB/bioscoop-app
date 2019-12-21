package be.ugent.consumptionservice.domain;

import be.ugent.consumptionservice.ConsumptionServiceApplication;
import be.ugent.consumptionservice.adapters.OrderConsumptions;
import be.ugent.consumptionservice.persistence.ItemRepository;
import be.ugent.consumptionservice.persistence.ProductRepository;
import be.ugent.consumptionservice.persistence.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CateringService {

    private final Logger logger = LoggerFactory.getLogger(ConsumptionServiceApplication.class);

    private final ProductRepository productRepository;
    private final ItemRepository itemRepository;
    private final PurchaseRepository purchaseRepository;

    @Autowired
    private CateringService(ProductRepository productRepository,
                           ItemRepository itemRepository,
                           PurchaseRepository purchaseRepository){
        this.itemRepository = itemRepository;
        this.productRepository = productRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public OrderConsumptions orderConsumptions(List<Product> products){
        Purchase purchase = new Purchase();
        List<Item> items = new ArrayList<>();
        OrderConsumptions orderedConsumptions = new OrderConsumptions();
        List<Product> orderedProducts = new ArrayList<>();
        purchase = purchaseRepository.save(purchase);
        logger.info("CateringService at your service...");
        //check if the ordered products exist in our catalog
        for(Product p : products){
            if(p.getProductid() > 0){
                logger.info("productname " + p.getName());
                Optional<Product> thisProduct = productRepository.findById(p.getProductid());
                if(thisProduct.isPresent()){
                    orderedProducts.add(thisProduct.get());
                }else{
                    //when one of the products doesn't exist, the order proccess is stoped
                    return null;
                }
            }else{
                //when one of the products doesn't exist, the order proccess is stoped
                return null;
            }
        }

        //order the products
        for(Product p : orderedProducts){
            Item item = new Item(p, purchase);
            itemRepository.save(item);
            items.add(item);
        }
        purchase.setProducts(items);
        purchaseRepository.save(purchase);
        orderedConsumptions.setConsumptions(orderedProducts);
        orderedConsumptions.setPurchaseid(purchase.getPurchaseid());
        //return the ordered products
        return orderedConsumptions;
    }

}
