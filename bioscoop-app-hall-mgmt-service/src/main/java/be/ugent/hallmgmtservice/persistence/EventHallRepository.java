package be.ugent.hallmgmtservice.persistence;

import be.ugent.hallmgmtservice.domain.EventHall;
import be.ugent.hallmgmtservice.domain.Hall;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EventHallRepository extends MongoRepository<EventHall, String> {
    EventHall findByEventId(int eventId);
}
