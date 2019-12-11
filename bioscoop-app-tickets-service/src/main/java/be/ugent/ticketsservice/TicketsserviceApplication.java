package be.ugent.ticketsservice;

import be.ugent.ticketsservice.adapters.Channels;
import be.ugent.ticketsservice.adapters.MessageGateway;
import be.ugent.ticketsservice.domain.Ticket;
import be.ugent.ticketsservice.persistence.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@SpringBootApplication(scanBasePackages={"be.ugent.ticketsservice"})
@EnableBinding(Channels.class)
public class TicketsserviceApplication {


    public static void main(String[] args) {
        SpringApplication.run(TicketsserviceApplication.class, args);
    }

/*    @Bean
    public CommandLineRunner populateDatabase(TicketRepository ticketRepository) {
        return (args) ->{
                System.out.println("Booking ticket");
                ticketRepository.deleteAll();
                Ticket t=new Ticket("Manu",13,2,"Joker",LocalDate.now().plus(3, ChronoUnit.DAYS),8.50);
                t.setDateBooked(LocalDate.now());
                ticketRepository.save(t);
                System.out.println("Ticket booked");

        };
    }*/

    @Bean
    public CommandLineRunner testGateway(MessageGateway gateway){
        return (args) -> {
            Ticket t = new Ticket("Manu", 13, 2, "Joker", LocalDate.now().plus(3, ChronoUnit.DAYS), 8.50);
            gateway.bookSeats(t);
        };
    }
}
