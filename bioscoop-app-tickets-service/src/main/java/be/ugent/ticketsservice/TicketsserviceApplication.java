package be.ugent.ticketsservice;

import be.ugent.ticketsservice.domain.Ticket;
import be.ugent.ticketsservice.persistence.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@SpringBootApplication
public class TicketsserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketsserviceApplication.class, args);
    }

    @Bean
    public CommandLineRunner populateDatabase(TicketRepository ticketRepository) {
        return (args) ->{
                ticketRepository.deleteAll();
                Ticket t=new Ticket();
                ticketRepository.save(t);
        };
    }
}
