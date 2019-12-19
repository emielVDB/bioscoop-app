package be.ugent.ticketsservice.domain;

import be.ugent.ticketsservice.adapters.Messaging.MessageGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookTicketSaga {
    private static Logger logger = LoggerFactory.getLogger(BookTicketSaga.class);
    private final MessageGateway gateway;
    private final Set<BookTicketListener> listeners;
    @Autowired
    public BookTicketSaga(MessageGateway gateway){
        this.gateway=gateway;
        this.listeners=new HashSet<>(5);
    }
    public void startBookTicketSaga(Ticket ticket){
        logger.info("Book ticket saga started.");
        gateway.bookSeats(ticket);
    }
    public void onSeatsBooked(Ticket ticket, List<Seat> seats){
        logger.info("OnSeatsBooked in bookTicketSaga");
        //set seats maakt niet uit zolang ze maar aan zelfde ticketid hangen
        ticket.setSeats(seats);
        //Kijken of velden van consumption niet null zijn, enkel met id werken
        if(ticket.getConsumptions().get(0).getName()!=null){
            //Dan is het al geboekt bij catering service
            this.ticketBookedComplete(ticket);
        }
    }
    public void onSeatsBookedFailed(Ticket ticket){
        this.bookTicketFailed(ticket);
    }
    public void bookTicketFailed(Ticket ticket){
        logger.info("Ticket booking failed");
        //Set booked staat van in het begin op false dus blijft zo
        this.listeners.forEach(l ->l.onBookTicketResult(ticket));
    }

    public void ticketBookedComplete(Ticket ticket){
        logger.info("Ticket booked successfully");
        ticket.setBooked(true);
        this.gateway.bookingTicketCompleted(ticket);
        this.listeners.forEach(l ->l.onBookTicketResult(ticket));
    }

    public void registerListener(BookTicketListener listener) {
        this.listeners.add(listener);
    }
}
