package be.ugent.staffservice.persistence;

import be.ugent.staffservice.domain.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task,String>
{


    //public List<Task> getTaskByBeginDate(LocalDateTime beginDate);

    @Query("SELECT t FROM Task t WHERE t.day =:day")
    public List<Task> getTaskByDay(String day);

}
