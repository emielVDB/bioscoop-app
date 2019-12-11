package be.ugent.scheduleservice;

import be.ugent.scheduleservice.domain.EventType;
import be.ugent.scheduleservice.domain.Schedule;
import be.ugent.scheduleservice.persistence.ScheduleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class BioscoopAppScheduleServiceApplication {
    private static Logger logger= LoggerFactory.getLogger(BioscoopAppScheduleServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BioscoopAppScheduleServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner populateDatabase(ScheduleRepository scheduleRepository) {
        return (args) ->{
            logger.info("Insert");

            scheduleRepository.deleteAll();
            //LocalDateTime beginDate,LocalDateTime endDate,int zaalNmr,int mediaId, EventType eventType


            LocalDateTime date=LocalDateTime.of(2018,11,2,5,0,0);
            Schedule schedule =new Schedule(date,date,10,6,EventType.FILM);
            scheduleRepository.save(schedule);

            date=LocalDateTime.of(2018,11,2,5,0,0);
            schedule =new Schedule(date,date,11,4,EventType.FILM);
            scheduleRepository.save(schedule);

            date=LocalDateTime.of(2018,11,5,5,0,0);
            schedule =new Schedule(date,date,11,5,EventType.FILM);
            scheduleRepository.save(schedule);

            date=LocalDateTime.of(2018,11,6,5,0,0);
            schedule =new Schedule(date,date,12,7,EventType.FILM);
            scheduleRepository.save(schedule);




            logger.info("Data in de DB");
            for (Schedule s: scheduleRepository.findAll())
            {
                logger.info(s.getZaalNmr()+"");
                logger.info(s.getBeginDate()+"");

            }


        };
    }


}
