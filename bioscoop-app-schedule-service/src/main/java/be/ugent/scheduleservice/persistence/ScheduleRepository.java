package be.ugent.scheduleservice.persistence;

import be.ugent.scheduleservice.domain.Schedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule,String>
{


    //public List<Schedule> getScheduleByBeginDate(LocalDateTime beginDate);

    @Query("SELECT s FROM Schedule s WHERE cast(s.beginDate as date) = cast(:day as date)")
    public List<Schedule> getScheduleByDay(String day);



    //SELECT * FROM schedule.schedule WHERE (11 = zaal_nmr) AND NOT (('2018-11-02 05:00:00'<begin_date AND '2018-11-02 08:00:00'<begin_date) OR ('2018-11-02 05:00:00'>end_date AND '2018-11-02 08:00:00'>end_date))
    @Query("SELECT s FROM Schedule s WHERE (:zaalNmr = s.zaalNmr) AND NOT ((cast(:beginTimestamp as timestamp)<s.beginDate AND cast(:endTimestamp as timestamp)<s.beginDate) OR (cast(:beginTimestamp as timestamp)>s.endDate AND cast(:endTimestamp as timestamp)>s.endDate))")
    public List<Schedule> getMoviesAtTimeAndHall(String beginTimestamp,String endTimestamp,int zaalNmr);

}
