package be.ugent.scheduleservice.adapter;

import be.ugent.scheduleservice.adapter.messaging.MessageGateway;
import be.ugent.scheduleservice.domain.EventType;
import be.ugent.scheduleservice.domain.Schedule;
import be.ugent.scheduleservice.domain.ScheduleWithAdTime;
import be.ugent.scheduleservice.persistence.ScheduleRepository;
import be.ugent.scheduleservice.service.AdvertisementTaskGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("schedule")
public class ScheduleRestController {
    @Autowired
    ScheduleRepository scheduleRepository;
    //@Autowired
    //AdvertisementTaskGenerator advertisementTaskGenerator;

    private static Logger logger = LoggerFactory.getLogger(ScheduleRestController.class);


    private final MessageGateway messageGateway;
    @Autowired
    public ScheduleRestController(MessageGateway messageGateway) {
        this.messageGateway = messageGateway;
    }




    //http://127.0.0.1:2223/schedule/test
    //POST TEST
    /*@GetMapping("/test")
    public ResponseEntity test()
    {
        String eventId="1";
        String seconds="60";
        String retValue=advertisementTaskGenerator.PostAdvertisementSlots(eventId,seconds);
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }*/




    @GetMapping("/test")
    public ResponseEntity test()
    {
        LocalDateTime date=LocalDateTime.of(2018,11,2,5,0,0);
        LocalDateTime endDate=LocalDateTime.of(2018,11,2,7,0,0);
        Schedule schedule =new Schedule(date,endDate,10,6, EventType.FILM);
        //messageGateway.addAdvertisementSlots(schedule);
        return ResponseEntity.status(HttpStatus.CREATED).body("OKE");
    }


    @GetMapping()
    public Iterable<Schedule> getAll()
    {
        return scheduleRepository.findAll();
    }


    //via -> http://127.0.0.1:2223/schedule/2018-11-02
    @GetMapping("/{datum}")
    public Iterable<Schedule> getByDay(@PathVariable("datum") String datum)
    {
        //String localDate="2019-12-12";
        //return scheduleRepository.getScheduleByDay(localDate);
        return scheduleRepository.getScheduleByDay(datum);
    }

    //via -> http://127.0.0.1:2223/schedule/add
    @PostMapping("add")
    //public Iterable<Schedule> postSchedule(@RequestBody Schedule schedule)
    public ResponseEntity addSchedule(@RequestBody Schedule schedule)
    {
        /*String beginTime="2018-11-02 02:00:00";
        String endTime="2018-11-02 10:00:00";
        int zaalNmr=11;*/

        if(schedule.getBeginDate()==null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Begin date is empty");
        }
        if(schedule.getEndDate()==null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("End date is empty");
        }

        Iterable<Schedule> sch=scheduleRepository.getMoviesAtTimeAndHall(schedule.getBeginDate().toString(),schedule.getEndDate().toString(),schedule.getZaalNmr());
        if(sch.iterator().hasNext())
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A Movie was already planned");
        }

        scheduleRepository.save(schedule);
        logger.info(schedule.getEventId()+"");
        messageGateway.BookHall(schedule);

        ScheduleWithAdTime scheduleWithAdTime=new ScheduleWithAdTime(schedule,5);
        messageGateway.addAdvertisementSlots(scheduleWithAdTime);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
    }



    //via -> http://127.0.0.1:2223/schedule/remove
    // met bijvoorbeeld
    // {
    //	"eventId": 29
    //}
    @Transactional
    @PostMapping("remove")
    //public Iterable<Schedule> postSchedule(@RequestBody Schedule schedule)
    public ResponseEntity removeSchedule(@RequestBody Schedule schedule)
    {
        Schedule s= scheduleRepository.getScheduleByEventId(schedule.getEventId());
        if(s==null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body("Could not find event with id:"+schedule.getEventId());
        }
        messageGateway.removeAdsSlot(s);
        messageGateway.removeBookedHall(s);

        scheduleRepository.removeByEventId(s.getEventId());

        return ResponseEntity.status(HttpStatus.CREATED).body("event with id "+s.getEventId()+" removed");
    }


}
