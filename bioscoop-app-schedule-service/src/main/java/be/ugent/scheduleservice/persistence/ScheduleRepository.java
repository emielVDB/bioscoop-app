package be.ugent.scheduleservice.persistence;

import be.ugent.scheduleservice.domain.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule,String>
{


    public List<Schedule> getScheduleByBeginDate(LocalDateTime beginDate);




}
