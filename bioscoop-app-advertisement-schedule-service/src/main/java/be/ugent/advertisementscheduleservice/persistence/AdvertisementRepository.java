package be.ugent.advertisementscheduleservice.persistence;

import be.ugent.advertisementscheduleservice.domain.Advertisement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends CrudRepository<Advertisement,String> {

    @Query("SELECT a FROM Advertisement a WHERE a.beginTime= cast(:time as timestamp)")
    public List<Advertisement> getScheduleByDay(String time);
}
