package be.ugent.advertisementscheduleservice.adapter;

import be.ugent.advertisementscheduleservice.domain.AdvertisementSlots;
import be.ugent.advertisementscheduleservice.domain.ReservedAdvertisements;
import be.ugent.advertisementscheduleservice.persistence.AdvertisementSlotsRepository;
import be.ugent.advertisementscheduleservice.persistence.ReservedAdvertisementsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("advertisement")
public class AdvertisementRestController {

    private static Logger logger = LoggerFactory.getLogger(AdvertisementRestController.class);

    @Autowired
    AdvertisementSlotsRepository advertisementSlotsRepository;
    @Autowired
    ReservedAdvertisementsRepository reservedAdvertisementsRepository;

    //via -> http://127.0.0.1:2226/advertisement
    @GetMapping()
    public Iterable<AdvertisementSlots> getAll()
    {
        return advertisementSlotsRepository.findAll();
    }



    @GetMapping("/test")
    public ResponseEntity test()
    {
        logger.info("SEND");
        return ResponseEntity.status(HttpStatus.CREATED).body("OKE");
    }


    @PostMapping()
    //public Iterable<Schedule> postSchedule(@RequestBody Schedule schedule)
    public ResponseEntity addAdvertisement(@RequestBody int eventId,ReservedAdvertisements reservedAdvertisements)
    {

        //int seconds= ...reservedAdvertisements.getMediaId();

        reservedAdvertisementsRepository.save(reservedAdvertisements);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
    }



}
