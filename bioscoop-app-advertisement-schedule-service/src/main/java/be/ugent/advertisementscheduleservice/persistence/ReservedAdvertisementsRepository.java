package be.ugent.advertisementscheduleservice.persistence;

import be.ugent.advertisementscheduleservice.domain.AdvertisementSlots;
import be.ugent.advertisementscheduleservice.domain.ReservedAdvertisements;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservedAdvertisementsRepository extends CrudRepository<ReservedAdvertisements,String> {

    public void removeById(int id);
    public ReservedAdvertisements getReservedAdvertisementsById(int id);
    public List<ReservedAdvertisements> getReservedAdvertisementsByAdvertisementSlots(AdvertisementSlots advertisementSlots);

}
