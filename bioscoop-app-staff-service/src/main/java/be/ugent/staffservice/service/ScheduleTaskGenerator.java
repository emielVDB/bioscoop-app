package be.ugent.staffservice.service;

import be.ugent.staffservice.domain.*;
import be.ugent.staffservice.persistence.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleTaskGenerator {

    @Autowired
    TaskRepository taskRepository;

    @Value("${schedule.url}")
    private String scheduleUrl;

    public String getScheduleUrl(){
        return scheduleUrl;
    }

    public void generateTasks(String day){
        final String uri = getScheduleUrl()+"/"+day;
        RestTemplate restTemplate = new RestTemplate();

        Event[] result = restTemplate.getForObject(uri, Event[].class);


        List<Task> deleteTasks = new ArrayList<>();
        for(Task task : taskRepository.getTaskByDay(day)){
            if(task.getGeneretedBy() == TaskGenerators.EVENT_SCHEDULE){
                deleteTasks.add(task);
            }
        }
        taskRepository.deleteAll(deleteTasks);

        if(result == null) return;
        generate(result, day);
    }

    private void generate(Event[] events, String day){
        TaskGenerators generator = TaskGenerators.EVENT_SCHEDULE;
        LocalDateTime generationDate = LocalDateTime.now();

        for (Event event: events) {
            LocalDateTime beforeStart = event.getBeginDate().minusMinutes(15);
            LocalDateTime afterEnd = event.getBeginDate().minusMinutes(15);

            taskRepository.save(new Task("Security hall", beforeStart, afterEnd, "hall " + event.getZaalNmr(), StaffType.SECURITY, 2, day, generationDate, generator));
            taskRepository.save(new Task("Clean hall", event.getEndDate(), afterEnd, "hall " + event.getZaalNmr(), StaffType.CLEANING, 3, day, generationDate, generator));
            taskRepository.save(new Task("Projector managing", beforeStart, afterEnd, "hall " + event.getZaalNmr(), StaffType.PROJECTOR_TECHNICIAN, 1, day, generationDate, generator));
        }

        taskRepository.save(new Task("Ticket desk", events[0].getBeginDate().minusMinutes(30), events[events.length-1].getBeginDate().plusMinutes(20), "ticket desk", StaffType.BASIC, 5, day, generationDate, generator));
        taskRepository.save(new Task("Catering", events[0].getBeginDate().minusMinutes(30), events[events.length-1].getBeginDate().plusMinutes(30), "catering", StaffType.BASIC, 10, day, generationDate, generator));

    }
}
