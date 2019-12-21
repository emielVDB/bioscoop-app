package be.ugent.ticketsservice.domain;

import be.ugent.ticketsservice.adapters.Messaging.TicketEventHandler;
import be.ugent.ticketsservice.persistence.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository repository;
    private final BookTicketSaga bookTicketSaga;
    private static Logger logger = LoggerFactory.getLogger(TicketService.class);
    @Autowired
    public TicketService(TicketRepository repository,BookTicketSaga bookTicketSaga){
        this.repository=repository;
        this.bookTicketSaga=bookTicketSaga;
    }

    public void bookTicket(Ticket ticket){
        synchronized (this.bookTicketSaga){
            this.bookTicketSaga.startBookTicketSaga(ticket);
        }
    }
    public synchronized void seatsBooked(Long id, List<Seat> seats){
        Optional<Ticket> ticket=this.repository.findById(id);
        if(ticket.isPresent()){
            this.bookTicketSaga.onSeatsBooked(ticket.get(),seats);
            this.repository.save(ticket.get());
        }
        else {
            //Komt voor als book seats slaagt maar de consumptions konden niet geboekt worden
            logger.info("Book seats wordt teniet gedaan");
            Ticket ticketSeats=new Ticket();
            ticketSeats.setSeats(seats);
            this.bookTicketSaga.deleteSeatsTicketGone(ticketSeats);
        }
    }
    public synchronized void failedToBookSeats(Long id){
        Optional<Ticket> ticket=this.repository.findById(id);
        if(ticket.isPresent()) {
            this.bookTicketSaga.onSeatsBookedFailed(ticket.get());
            logger.info("Delete ticket failedToBookSeats met id:" + id);
            this.repository.deleteById(id);
        }
    }

    public synchronized void consumptionsBooked(Long id,List<Consumption> consumptions,Long purchaseid){
        Optional<Ticket> ticket=this.repository.findById(id);
        if(ticket.isPresent()) {
            ticket.get().setPurchaseid(purchaseid);
            this.bookTicketSaga.onConsumptionsBooked(ticket.get(), consumptions);
            this.repository.save(ticket.get());
        }
        else {
            logger.info("Book consumptions wordt teniet gedaan");
            Ticket ticketConsumptions=new Ticket();
            ticketConsumptions.setPurchaseid(purchaseid);
            this.bookTicketSaga.deleteConsumptionsTicketGone(ticketConsumptions);
        }
    }
    public synchronized void failedToBookConsumptions(Long id){
        Optional<Ticket> ticket=this.repository.findById(id);
        if(ticket.isPresent()) {
            this.bookTicketSaga.onConsumptionsBookedFailed(ticket.get());
            logger.info("Delete ticket failedToBookConsumptions met id:" + id);
            this.repository.deleteById(id);
        }

    }


    public void registerBookTicketListener(BookTicketListener listener) {
        this.bookTicketSaga.registerListener(listener);
    }

}
