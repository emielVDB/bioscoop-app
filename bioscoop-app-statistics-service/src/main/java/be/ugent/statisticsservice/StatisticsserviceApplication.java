package be.ugent.statisticsservice;

import be.ugent.statisticsservice.adapters.Channels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(Channels.class)
public class StatisticsserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatisticsserviceApplication.class, args);
    }

}
