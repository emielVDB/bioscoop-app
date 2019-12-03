package be.ugent.ticketsservice.adapters;

import be.ugent.ticketsservice.domain.Ticket;
import be.ugent.ticketsservice.persistence.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("ticket")
public class TicketRestController {

    private final TicketRepository repository;

    @Autowired
    public TicketRestController(TicketRepository repo) {
        this.repository = repo;
    }

    @GetMapping
    public Iterable<Ticket> getTickets(){
        return repository.findAll();
    }
    @GetMapping("/before")
    public List<Ticket> getTicketsBeforeDate(@RequestParam("date") LocalDate date){
        return repository.findByDateBookedBefore(date);
    }
    @PostMapping()
    public void bookTicket(@RequestBody Ticket ticket){

        ticket.setDateBooked(LocalDate.now());
        repository.save(ticket);
    }
}
