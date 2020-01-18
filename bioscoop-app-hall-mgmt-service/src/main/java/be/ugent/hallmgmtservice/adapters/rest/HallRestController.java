package be.ugent.hallmgmtservice.adapters.rest;

import be.ugent.hallmgmtservice.domain.EventHall;
import be.ugent.hallmgmtservice.domain.Hall;
import be.ugent.hallmgmtservice.persistence.EventHallRepository;
import be.ugent.hallmgmtservice.persistence.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hall")
@CrossOrigin(origins = "*")
public class HallRestController {
    private final HallRepository hallRepository;

    @Autowired
    public HallRestController(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @GetMapping
    public Iterable<Hall> getAllHalls(){
        return this.hallRepository.findAll();
    }

    @GetMapping("/{number}")
    public ResponseEntity<Hall> getHallByNumber(@PathVariable("number") int number) {
        Hall hall = this.hallRepository.findByNumber(number);
        if(hall == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hall, HttpStatus.OK);
    }
}
