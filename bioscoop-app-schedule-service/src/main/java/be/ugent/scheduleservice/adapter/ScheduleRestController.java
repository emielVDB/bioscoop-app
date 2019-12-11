package be.ugent.scheduleservice.adapter;

import be.ugent.scheduleservice.domain.Schedule;
import be.ugent.scheduleservice.persistence.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("schedule")
@CrossOrigin(origins = "*")
public class ScheduleRestController {
    @Autowired
    ScheduleRepository scheduleRepository;

    @GetMapping()
    public Iterable<Schedule> getAll()
    {
        return scheduleRepository.findAll();
    }


    @GetMapping("/{datum}")
    public Iterable<Schedule> getByDay(@PathVariable("datum") String datum)
    {
        //String localDate="2019-12-12";
        //return scheduleRepository.getScheduleByDay(localDate);
        return scheduleRepository.getScheduleByDay(datum);
    }

    @PostMapping()
    //public Iterable<Schedule> postSchedule(@RequestBody Schedule schedule)
    public ResponseEntity postSchedule(@RequestBody Schedule schedule)
    {

        /*String beginTime="2018-11-02 02:00:00";
        String endTime="2018-11-02 10:00:00";
        int zaalNmr=11;*/

        Iterable<Schedule> sch=scheduleRepository.getMoviesAtTimeAndHall(schedule.getBeginDate().toString(),schedule.getEndDate().toString(),schedule.getZaalNmr());
        if(sch.iterator().hasNext())
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A Movie was already planned");
        }

        scheduleRepository.save(schedule);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
    }






}
