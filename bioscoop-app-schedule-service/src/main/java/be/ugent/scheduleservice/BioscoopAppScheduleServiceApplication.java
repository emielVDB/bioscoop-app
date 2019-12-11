package be.ugent.scheduleservice;

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

            /*scheduleRepository.deleteAll();
            Schedule schedule =new Schedule();

            LocalDateTime Nu = LocalDateTime.now();
            //2010-02-02T01:05
            schedule.setBeginDate(Nu);
            schedule.setEndDate(Nu);
            schedule.setZaalNmr(10);
            schedule.setMediaId(1);
            schedule.setMediaId(2);

            //scheduleRepository.save(schedule);




            logger.info("Data in de DB");
            for (Schedule s: scheduleRepository.findAll())
            {
                logger.info(s.getZaalNmr()+"");
                logger.info(s.getBeginDate()+"");

            }
            */

        };
    }


}
