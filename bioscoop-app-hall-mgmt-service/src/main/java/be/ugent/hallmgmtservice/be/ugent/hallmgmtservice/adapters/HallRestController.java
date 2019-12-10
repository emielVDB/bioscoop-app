package be.ugent.hallmgmtservice.be.ugent.hallmgmtservice.adapters;

import be.ugent.hallmgmtservice.domain.Hall;
import be.ugent.hallmgmtservice.persistence.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
