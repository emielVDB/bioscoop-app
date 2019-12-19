package be.ugent.staffservice.adapter;

import be.ugent.staffservice.domain.Task;
import be.ugent.staffservice.domain.TaskGenerators;
import be.ugent.staffservice.persistence.TaskRepository;
import be.ugent.staffservice.service.ScheduleTaskGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("staff")
@CrossOrigin(origins = "*")
public class StaffRestController {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ScheduleTaskGenerator scheduleTaskGenerator;

    @GetMapping("/{day}")
    public Iterable<Task> getByDay(@PathVariable("day") String day)
    {
        return taskRepository.findAll();
    }

    @GetMapping("/generate/{day}")
    public ResponseEntity generateTasks(@PathVariable("day") String day){
        scheduleTaskGenerator.generateTasks(day);
        return ResponseEntity.ok("Generation started");
    }

    @PostMapping("/")
    public ResponseEntity addCustomTask(@RequestBody Task task){
        task.setGeneretedBy(TaskGenerators.CUSTOM);
        LocalDateTime now = LocalDateTime.now();
        task.setDay(now.getYear()+ "-"+now.getMonth()+"-"+now.getDayOfMonth());
        task.setLastUpdate(LocalDateTime.now());
        Task result = taskRepository.save(task);
        return ResponseEntity.ok(result);
    }

}
