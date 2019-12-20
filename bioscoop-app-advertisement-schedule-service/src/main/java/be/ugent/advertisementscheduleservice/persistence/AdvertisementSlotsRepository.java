package be.ugent.advertisementscheduleservice.persistence;

import be.ugent.advertisementscheduleservice.domain.AdvertisementSlots;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementSlotsRepository extends CrudRepository<AdvertisementSlots,String> {

    @Query("SELECT a FROM AdvertisementSlots a WHERE a.adSpace= :duration")
    public List<AdvertisementSlots> getScheduleByDay(int duration);
}