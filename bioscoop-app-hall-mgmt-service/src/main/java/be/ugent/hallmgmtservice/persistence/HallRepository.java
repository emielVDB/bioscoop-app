package be.ugent.hallmgmtservice.persistence;

import be.ugent.hallmgmtservice.domain.Hall;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HallRepository extends MongoRepository<Hall, String> {
    Hall findByName(String Name);

}
