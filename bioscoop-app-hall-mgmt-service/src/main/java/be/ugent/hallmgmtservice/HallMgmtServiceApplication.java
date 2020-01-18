package be.ugent.hallmgmtservice;

import be.ugent.hallmgmtservice.adapters.messaging.Channels;
import be.ugent.hallmgmtservice.domain.*;
import be.ugent.hallmgmtservice.persistence.EventHallRepository;
import be.ugent.hallmgmtservice.persistence.HallRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import java.util.Random;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableBinding(Channels.class)
public class HallMgmtServiceApplication {

    Logger logger = LoggerFactory.getLogger(HallMgmtServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HallMgmtServiceApplication.class, args);
    }

    private Hall createHall(int number, String screenSize, int numberOfRows, int numberOfSeats){
        //create seats
        Random rand = new Random();
        List<Seat> seats = new ArrayList<Seat>();
        for(int r = 1; r <= numberOfRows; r++){
            for(int s = 1; s <= numberOfSeats; s++){
                Seat seat = new Seat(s, r, SeatType.NORMAL);
                SeatStatus status;
                int random = rand.nextInt(10);
                if(random <= 8){
                    status = SeatStatus.AVAILABLE;
                }else if(random == 9){
                    status = SeatStatus.OUTOFUSE;
                }else{
                    status = SeatStatus.NOTBOOKABLE;
                }
                seat.setStatus(status);
                seats.add(seat);
            }
        }
        return new Hall(number, seats, screenSize);
    }

    @Bean
    public CommandLineRunner populateDatabase(HallRepository repository){
        return(args -> {
            repository.deleteAll();
            logger.info("populating with data...");
            repository.save(createHall(1, "5m x 10m", 10, 5));
            repository.save(createHall( 2, "8m x 12m", 3, 10));
            repository.save(createHall(3, "2m x 3m", 7, 6));
            logger.info("populated with data");
        });
    }

    @Bean
    public CommandLineRunner postInEventHall(HallRepository hallRepository, EventHallRepository eventHallRepository){
        return(args ->{
            eventHallRepository.deleteAll();
            Hall hall = hallRepository.findByNumber(1);
            EventHall eventHall = new EventHall(hall, 4);
            eventHallRepository.save(eventHall);
            logger.info("added event hall");
        });
    }

//    @Bean
//    public CommandLineRunner sendMessage(MessageGateway gateway, EventHallRepository eventHallRepository){
//        return(args -> {
//            logger.info("zend bericht");
//            gateway.bookSeatsCompleted(eventHallRepository.findByEventId(1));
//
//        });
//    }
}