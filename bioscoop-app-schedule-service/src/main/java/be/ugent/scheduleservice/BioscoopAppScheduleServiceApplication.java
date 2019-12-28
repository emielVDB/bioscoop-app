package be.ugent.scheduleservice;

import be.ugent.scheduleservice.adapter.messaging.Channels;
//import be.ugent.scheduleservice.adapter.messaging.MessageGateway;
import be.ugent.scheduleservice.adapter.messaging.MessageGateway;
import be.ugent.scheduleservice.domain.EventType;
import be.ugent.scheduleservice.domain.Schedule;
import be.ugent.scheduleservice.domain.ScheduleWithAdTime;
import be.ugent.scheduleservice.persistence.ScheduleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Gateway;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
@EnableBinding(Channels.class)
public class BioscoopAppScheduleServiceApplication {
    private static Logger logger= LoggerFactory.getLogger(BioscoopAppScheduleServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BioscoopAppScheduleServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner populateDatabase(MessageGateway messageGateway, ScheduleRepository scheduleRepository) {
        return (args) ->{
            logger.info("Insert");

            scheduleRepository.deleteAll();
            //LocalDateTime beginDate,LocalDateTime endDate,int zaalNmr,int mediaId, EventType eventType


            LocalDateTime date=LocalDateTime.of(2018,11,2,5,0,0);
            LocalDateTime endDate=LocalDateTime.of(2018,11,2,7,0,0);
            Schedule schedule =new Schedule(date,endDate,10,6,EventType.FILM);
            scheduleRepository.save(schedule);

            date=LocalDateTime.of(2018,11,2,5,0,0);
            endDate=LocalDateTime.of(2018,11,2,7,0,0);
            schedule =new Schedule(date,endDate,11,4,EventType.FILM);
            scheduleRepository.save(schedule);

            date=LocalDateTime.of(2018,11,5,5,0,0);
            endDate=LocalDateTime.of(2018,11,5,7,0,0);
            schedule =new Schedule(date,endDate,11,5,EventType.FILM);
            scheduleRepository.save(schedule);

            date=LocalDateTime.of(2018,11,6,5,0,0);
            endDate=LocalDateTime.of(2018,11,6,7,0,0);
            schedule =new Schedule(date,endDate,12,7,EventType.FILM);
            scheduleRepository.save(schedule);




            logger.info("Data in de DB");
            for (Schedule s: scheduleRepository.findAll())
            {
                logger.info("zaalNmr: "+s.getZaalNmr()+"");
                logger.info(s.getBeginDate()+"");
                logger.info("id: "+s.getEventId()+"");

                ScheduleWithAdTime scheduleWithAdTime=new ScheduleWithAdTime(s,600);
                messageGateway.addAdvertisementSlots(scheduleWithAdTime);

            }


        };
    }


    /*@Bean
    public CommandLineRunner testGateway(MessageGateway messageGateway, ScheduleRepository scheduleRepository){
        return (args) -> {


            LocalDateTime date=LocalDateTime.of(2018,11,2,5,0,0);
            LocalDateTime endDate=LocalDateTime.of(2018,11,2,7,0,0);
            Schedule schedule =new Schedule(date,endDate,10,6,EventType.FILM);

            int seconds=600;
            //messageGateway.addAdvertisementSlots(schedule,seconds);

            //messageGateway.addAdvertisementSlots();
            logger.info("TEST KAFKA");

        };
    }*/

}
