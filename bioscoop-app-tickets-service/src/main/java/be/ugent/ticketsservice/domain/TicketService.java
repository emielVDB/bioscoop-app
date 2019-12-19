package be.ugent.ticketsservice.domain;

import be.ugent.ticketsservice.adapters.Messaging.TicketEventHandler;
import be.ugent.ticketsservice.persistence.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        final Ticket ticket=this.repository.findById(id).get();
        this.bookTicketSaga.onSeatsBooked(ticket,seats);
        this.repository.save(ticket);
    }
    public synchronized void failedToBookSeats(Long id){
        final Ticket ticket=this.repository.findById(id).get();
        this.bookTicketSaga.onSeatsBookedFailed(ticket); // Nog implementeren dat op de hoogte wordt gesteld
        logger.info("Delete ticket met id:"+ id);
        this.repository.deleteById(id);
    }


    public void registerBookTicketListener(BookTicketListener listener) {
        this.bookTicketSaga.registerListener(listener);
    }

}
