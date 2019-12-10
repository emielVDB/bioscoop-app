package be.ugent.hallmgmtservice;

import be.ugent.hallmgmtservice.domain.*;
import be.ugent.hallmgmtservice.persistence.HallRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HallMgmtServiceApplication {

    Logger logger = LoggerFactory.getLogger(HallMgmtServiceApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(HallMgmtServiceApplication.class, args);
//        System.out.print("hall management service started...");
    }

    private Hall createHall(String name, String screenSize, int numberOfRows, int numberOfSeats){
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
        return new Hall(name, seats, screenSize);
    }

    @Bean
    public CommandLineRunner populateDatabase(HallRepository repository){
        return(args -> {
            repository.deleteAll();
            logger.info("populating with data...");
            repository.save(createHall("Zaal 1", "5m x 10m", 20, 35));
            repository.save(createHall("Zaal 2", "8m x 12m", 30, 40));
            repository.save(createHall("Zaal 3", "2m x 3m", 8, 15));
        });
    }

}