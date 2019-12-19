package be.ugent.ticketsservice;

import be.ugent.ticketsservice.adapters.Messaging.Channels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(Channels.class)
public class TicketsserviceApplication {

    private static Logger logger = LoggerFactory.getLogger(TicketsserviceApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(TicketsserviceApplication.class, args);
    }

/*    @Bean
    public CommandLineRunner populateDatabase(TicketRepository ticketRepository) {
        return (args) ->{
                logger.info("Booking ticket in main");
                ticketRepository.deleteAll();
                Consumption c=new Consumption("cola",2);
                Consumption d=new Consumption("popcorn",3.50);
                List<Consumption> consumptions=new ArrayList<>();
                consumptions.add(c);
                consumptions.add(d);
                List<Seat> seats=new ArrayList<>();
                Seat s=new Seat(3L);
                seats.add(s);
                Ticket t=new Ticket("Manu",seats,2,"Joker",4,LocalDate.now().plus(3, ChronoUnit.DAYS),8.50,consumptions);

                t.setDateBooked(LocalDate.now());
                Ticket ticketreturn=ticketRepository.save(t);
                logger.info("Ticket booked");
                Ticket ticketje=ticketRepository.findById(ticketreturn.getId()).get();
                List<Seat> newseats=ticketje.getSeats();
                newseats.get(0).setRowNumber(15);
                ticketje.setSeats(newseats);
                logger.info("Change ticket just booked");

                ticketRepository.save(ticketje);
                logger.info("Saved changed ticket");
        };
    }*/

/*    @Bean
    public CommandLineRunner testGateway(TicketService service){
        return (args) -> {
            Consumption c=new Consumption("cola",2);
            Consumption d=new Consumption("popcorn",3.50);
            List<Consumption> consumptions=new ArrayList<>();
            consumptions.add(c);
            consumptions.add(d);
            List<Seat> seats=new ArrayList<>();
            Seat s=new Seat(3L);
            seats.add(s);
            Ticket t=new Ticket("Manu",seats,2,"Joker",4,LocalDate.now().plus(3, ChronoUnit.DAYS),8.50,consumptions);
            service.bookTicket(t);

        };
    }*/
}
