package be.ugent.hallmgmtservice;

import be.ugent.hallmgmtservice.domain.*;
import be.ugent.hallmgmtservice.persistence.HallRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HallMgmtServiceApplication {

    Logger logger = LoggerFactory.getLogger(HallMgmtServiceApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(HallMgmtServiceApplication.class, args);
//        System.out.print("hall management service started...");
    }

    @Bean
    public CommandLineRunner populateDatabase(HallRepository repository){
        return(args -> {
            logger.info("populating with data...");
            List<Seat> seats = new ArrayList<Seat>();
            for(int i = 1; i < 20; i++){
                Seat s = new Seat(i, SeatType.NORMAL, SeatStatus.AVAILABLE);
                seats.add(s);
            }
            List<Row> rows = new ArrayList<Row>();
            for(int i = 1; i < 5; i++){
                rows.add(new Row(i, seats));
            }

            Hall h = new Hall("Zaal 1", rows, "5m x 10m");
            repository.save(h);
            logger.info("added hall");
        });
    }

}