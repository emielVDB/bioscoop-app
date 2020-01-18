package be.ugent.advertisementscheduleservice;

import be.ugent.advertisementscheduleservice.adapter.messaging.Channels;
import be.ugent.advertisementscheduleservice.domain.AdvertisementSlots;
import be.ugent.advertisementscheduleservice.domain.ReservedAdvertisements;
import be.ugent.advertisementscheduleservice.persistence.AdvertisementSlotsRepository;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
@EnableBinding(Channels.class)
public class BioscoopAppAdvertisementScheduleServiceApplication {
    private static Logger logger= LoggerFactory.getLogger(BioscoopAppAdvertisementScheduleServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BioscoopAppAdvertisementScheduleServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner populateDatabase(AdvertisementSlotsRepository advertisementSlotsRepository) {
        return (args) ->{
            logger.info("Insert");

            advertisementSlotsRepository.deleteAll();

            advertisementSlotsRepository.save(new AdvertisementSlots(1,5,new ReservedAdvertisements(1),new ReservedAdvertisements(5)));


            logger.info("Data in de DB");
            for (AdvertisementSlots s: advertisementSlotsRepository.findAll())
            {
                logger.info(s.getAdvertisementId()+"");
            }

        };
    }
}
