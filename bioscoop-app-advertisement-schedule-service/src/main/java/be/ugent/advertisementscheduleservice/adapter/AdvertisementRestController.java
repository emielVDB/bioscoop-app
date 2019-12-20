package be.ugent.advertisementscheduleservice.adapter;

import be.ugent.advertisementscheduleservice.domain.AdvertisementSlots;
import be.ugent.advertisementscheduleservice.persistence.AdvertisementSlotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("advertisement")
@CrossOrigin(origins = "*")
public class AdvertisementRestController {

    @Autowired
    AdvertisementSlotsRepository advertisementSlotsRepository;

    //via -> http://127.0.0.1:2226/advertisement
    @GetMapping()
    public Iterable<AdvertisementSlots> getAll()
    {
        return advertisementSlotsRepository.findAll();
    }

    //via -> http://127.0.0.1:2226/advertisement
    @PostMapping()
    //public Iterable<Schedule> postSchedule(@RequestBody Schedule schedule)
    public ResponseEntity addAdvertisement(@RequestBody AdvertisementSlots advertisement)
    {

        //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A Movie was already planned");
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
    }

    //via -> http://127.0.0.1:2226/advertisement/slots
    @PostMapping("/slots")
    //public Iterable<Schedule> postSchedule(@RequestBody Schedule schedule)
    public ResponseEntity addAdvertisementSlots(@RequestBody String eventId, String seconds)
    //public ResponseEntity addAdvertisementSlots()
    {

        //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A Movie was already planned");
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created "+eventId+"  "+seconds);
        //return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created ");
    }




}
