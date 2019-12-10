package be.ugent.scheduleservice.schedule;

import be.ugent.scheduleservice.domain.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import be.ugent.scheduleservice.persistence.ScheduleRepository;

@SpringBootApplication
public class ScheduleManagementApplication {
    private static Logger logger= LoggerFactory.getLogger(ScheduleManagementApplication.class);

    public static void main(String[] args)
    {
        SpringApplication.run(ScheduleManagementApplication.class,args);
    }

    @Bean
    public CommandLineRunner testRepo(ScheduleRepository scheduleRepository)
    {
        return(args)->{
            for (Schedule s: scheduleRepository.findAll())
            {
                logger.info(s.getZaalNmr()+"");
            }
        }
    }



}

