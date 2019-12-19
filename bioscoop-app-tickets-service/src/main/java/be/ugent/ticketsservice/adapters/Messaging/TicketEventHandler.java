package be.ugent.ticketsservice.adapters.Messaging;

import be.ugent.ticketsservice.domain.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class TicketEventHandler {

    private static Logger logger = LoggerFactory.getLogger(TicketEventHandler.class);
    private final TicketService ticketService;

    @Autowired
    public TicketEventHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @StreamListener(Channels.BOOKED_SEATS)
    public void processBookedSeats(BookSeatResponse bookSeatResponse){
        if(bookSeatResponse.getSeats()==null){
            //Dan is het mis gegaan
            logger.info("Response message book seats: seats is null dus ticket boeken faalt");
            this.ticketService.failedToBookSeats(bookSeatResponse.getTicketid());
        }
        else{
            logger.info("Response message book seats geslaagd!");
            this.ticketService.seatsBooked(bookSeatResponse.getTicketid(),bookSeatResponse.getSeats());
        }
    }

    @StreamListener(Channels.BOOKED_CONSUMPTIONS)
    public void processBookedConsumptions(BookConsumptionResponse bookConsumptionResponse){
        if(bookConsumptionResponse.getConsumptions()==null){
            logger.info("Booked consumptions is null dus ticket boeken faalt");
            this.ticketService.failedToBookConsumptions(bookConsumptionResponse.getTicketid());
        }
        else {
            logger.info("BookConsumptionResponse is geslaagd");
            this.ticketService.consumptionsBooked(bookConsumptionResponse.getTicketid(),bookConsumptionResponse.getConsumptions());
        }
    }
}
