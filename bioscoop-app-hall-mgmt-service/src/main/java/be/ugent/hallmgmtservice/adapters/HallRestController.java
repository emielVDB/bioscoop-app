package be.ugent.hallmgmtservice.adapters;

import be.ugent.hallmgmtservice.domain.Hall;
import be.ugent.hallmgmtservice.persistence.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hall")
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
    public ResponseEntity<Hall> getHallByName(@PathVariable("number") int number) {
        Hall hall = this.hallRepository.findByNumber(number);
        if(hall == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hall, HttpStatus.OK);
    }
}
