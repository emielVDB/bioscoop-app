package be.ugent.consumptionservice.adapters;

import be.ugent.consumptionservice.ConsumptionServiceApplication;
import be.ugent.consumptionservice.domain.CateringService;
import be.ugent.consumptionservice.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OrderConsumptionEventHandler {

    private final Logger logger = LoggerFactory.getLogger(ConsumptionServiceApplication.class);
    private final CateringService cateringService;

    @Autowired
    public OrderConsumptionEventHandler(CateringService cateringService){this.cateringService = cateringService;}

    @StreamListener(Channels.ORDER_CONSUMPTIONS)
    @SendTo(Channels.CONSUMPTIONS_ORDERED)
    public OrderConsumptions orderConsumptions(OrderConsumptions request){
        logger.info("Reveived request to order consumptions with ticketid {} and eventid: {}",
                request.getTicketid(), request.getEventid());
        if(!request.getConsumptions().isEmpty()){
            logger.info("consumptions: ", request.getConsumptions());
            //purchase aanmaken en in de database steken
            OrderConsumptions orderConsumptions = cateringService.orderConsumptions(request.getConsumptions());
            if(orderConsumptions != null){
                orderConsumptions.setTicketid(request.getTicketid());
                orderConsumptions.setEventid(request.getEventid());
                return orderConsumptions;
            }
        }
        //when the order list was empty or the CateringService returns null, no consumptions were ordered
        return null;
    }

    @StreamListener(Channels.DELETE_ORDERED_CONSUMPTIONS)
    public void deleteOrderedConsumptions(OrderConsumptions request){

    }
}
