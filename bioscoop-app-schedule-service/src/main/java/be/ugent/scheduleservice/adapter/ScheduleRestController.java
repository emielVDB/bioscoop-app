package be.ugent.scheduleservice.adapter;

import be.ugent.scheduleservice.domain.Schedule;
import be.ugent.scheduleservice.persistence.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


}
