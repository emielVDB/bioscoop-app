package be.ugent.statisticsservice.adapters;

import be.ugent.statisticsservice.domain.Statistic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("statistics")
public class StatisticsRestController {
    private static Logger logger = LoggerFactory.getLogger(StatisticsRestController.class);

    @Autowired
    public StatisticsRestController() {
    }

    @GetMapping("/catering")
    public Statistic getCateringStatistics(){
        return null;
    }

    @GetMapping("/seats")
    public Statistic getSeatsStatistics(){
        return null;
    }
}
