package be.ugent.scheduleservice.persistence;

import be.ugent.scheduleservice.domain.Schedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule,String>
{


    //public List<Schedule> getScheduleByBeginDate(LocalDateTime beginDate);


    //@Query("SELECT s FROM schedule.schedule s WHERE cast(s.begin_date as date) = :day")
    //@Query("SELECT s FROM Schedule s")
    @Query("SELECT s FROM Schedule s WHERE cast(s.beginDate as date) = cast(:day as date)")
    //@Query("SELECT s FROM Schedule s")
    public List<Schedule> getScheduleByDay(String day);




}
