package be.ugent.advertisementscheduleservice.persistence;

import be.ugent.advertisementscheduleservice.domain.ReservedAdvertisements;
import org.springframework.data.repository.CrudRepository;

public interface ReservedAdvertisementsRepository extends CrudRepository<ReservedAdvertisements,String> {
}
