package be.ugent.ticketsservice.adapters.Rest;

import be.ugent.ticketsservice.domain.BookTicketListener;
import be.ugent.ticketsservice.domain.Ticket;
import be.ugent.ticketsservice.domain.TicketService;
import be.ugent.ticketsservice.persistence.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ticket")
public class TicketRestController implements BookTicketListener {
    private static Logger logger = LoggerFactory.getLogger(TicketRestController.class);
    private TicketRepository repository;
    private TicketService ticketService;
    private final Map<Long, DeferredResult<Ticket>> deferredResultMap;

    @Autowired
    public TicketRestController(TicketRepository repo,TicketService ticketService) {
        this.repository = repo;
        this.ticketService=ticketService;
        this.deferredResultMap=new HashMap<>(10);
    }

    @PostConstruct
    private void registerListener(){ticketService.registerBookTicketListener(this);}

    @GetMapping
    public Iterable<Ticket> getTickets(){
        return repository.findAll();
    }
    @GetMapping("/before")
    public List<Ticket> getTicketsBeforeDate(@RequestParam("date") LocalDate date){
        return repository.findByDateBookedBefore(date);
    }
    @PostMapping
    public DeferredResult<Ticket> bookTicket(@RequestBody Ticket ticket){
        // Hier nog check doen bij management service of de stoelen nog beschikbaar zijn
        // Ook nog mogelijke eten/drinken bestellen bij catering service
        logger.info("Ticket voor save");
        DeferredResult<Ticket> deferredResult=new DeferredResult<>(10000l);
        deferredResult.onTimeout(()->{
            deferredResult.setErrorResult("Timeout in request");
        });
        ticket.setDateBooked(LocalDate.now());
        try{
            Ticket t=repository.save(ticket);
            //Dan hier met het id doorwerken
            logger.info("Ticketid na save: " + t.getTicketid());
            this.deferredResultMap.put(t.getTicketid(),deferredResult);
            logger.info("Calling service in restcontroller to start book ticket saga");
            this.ticketService.bookTicket(t);
        }
        catch(Exception e){
            logger.info("ERROR in Try Catch restcontroller book ticket : "+e.getMessage());
        }

        return deferredResult;

    }
    private void performResponse(Ticket ticket){
        DeferredResult<Ticket> deferredResult=this.deferredResultMap.remove(ticket.getTicketid());
        if(deferredResult!=null && !deferredResult.isSetOrExpired()){
            logger.info("PerformResponse response setting van een ticket: "+ ticket.getTicketid());
            deferredResult.setResult(ticket);
        }
        else {
            logger.info("DeferredResult in performresponse: " +deferredResult);
        }
    }
    @Override
    public void onBookTicketResult(Ticket ticket) {
        this.performResponse(ticket);
    }
}
