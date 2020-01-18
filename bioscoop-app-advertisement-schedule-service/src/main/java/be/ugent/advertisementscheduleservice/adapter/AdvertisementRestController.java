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

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("advertisement")
@CrossOrigin(origins = "*")
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


    @PostMapping("add")
    //public Iterable<Schedule> postSchedule(@RequestBody Schedule schedule)
    public ResponseEntity addAdvertisement(@RequestBody ReservedAdvertisements reservedAdvertisements)
    {
        int adSlotId=reservedAdvertisements.getAdvertisementSlots().getAdvertisementId();
        AdvertisementSlots bestaand=advertisementSlotsRepository.getAdvertisementSlotsByAdvertisementId(adSlotId);
        if(bestaand==null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body("Could not find advertisementSlot with id:"+adSlotId);
        }

        List<ReservedAdvertisements> r=reservedAdvertisementsRepository.getReservedAdvertisementsByAdvertisementSlots(bestaand);
        if(r.size()>=bestaand.getAdSpace())
        {
            return ResponseEntity.status(HttpStatus.CREATED).body("Already the limit of advertisements are planned (max="+bestaand.getAdSpace()+")");
        }

        if(reservedAdvertisements.getMediaId()==-1)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body("Could not find a mediaId");
        }
        //int seconds= ...reservedAdvertisements.getMediaId();
        ReservedAdvertisements re=reservedAdvertisementsRepository.save(reservedAdvertisements);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created, new advertisements id="+re.getId());
    }

    @Transactional
    @PostMapping("remove")
    //public Iterable<Schedule> postSchedule(@RequestBody Schedule schedule)
    public ResponseEntity removeAdvertisement(@RequestBody ReservedAdvertisements reservedAdvertisements)
    {
        int id=reservedAdvertisements.getId();
        ReservedAdvertisements res= reservedAdvertisementsRepository.getReservedAdvertisementsById(id);
        if(res==null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body("Could not find an advertisement slot with id:"+id);
        }
        reservedAdvertisementsRepository.removeById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully removed");
    }


}
