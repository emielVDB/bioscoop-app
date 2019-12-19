package be.ugent.advertisementscheduleservice;

import be.ugent.advertisementscheduleservice.domain.Advertisement;
import be.ugent.advertisementscheduleservice.persistence.AdvertisementRepository;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;

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

            advertisementRepository.deleteAll();

            Timestamp beginTime=Timestamp.valueOf("2018-09-01 09:01:15");
            Timestamp endTime= Timestamp.valueOf("2018-09-01 09:01:50");
            Advertisement advertisement =new Advertisement(1,beginTime,endTime,1);

            advertisementRepository.save(advertisement);


            logger.info("Data in de DB");
            for (Advertisement s: advertisementRepository.findAll())
            {
                logger.info(s.getEventId()+"");
                logger.info(s.getMediaId()+"");

            }

        };
    }
}
