package be.ugent.hallmgmtservice.persistence;

import be.ugent.hallmgmtservice.domain.EventHall;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface EventHallRepository extends MongoRepository<EventHall, String> {
    EventHall findByEventHallId(int eventHallId);
}
