package be.ugent.staffservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BioscoopAppStaffServiceApplication {
    private static Logger logger= LoggerFactory.getLogger(BioscoopAppStaffServiceApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(BioscoopAppStaffServiceApplication.class, args);
    }
}
