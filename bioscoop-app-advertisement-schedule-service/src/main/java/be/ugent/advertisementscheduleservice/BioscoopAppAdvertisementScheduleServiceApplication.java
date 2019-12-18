package be.ugent.advertisementscheduleservice;

import be.ugent.advertisementscheduleservice.persistence.AdvertisementRepository;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BioscoopAppAdvertisementScheduleServiceApplication {
    private static Logger logger= LoggerFactory.getLogger(BioscoopAppAdvertisementScheduleServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BioscoopAppAdvertisementScheduleServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner populateDatabase(AdvertisementRepository advertisementRepository) {
        return (args) ->{
            logger.info("Insert");


        };
    }
}
