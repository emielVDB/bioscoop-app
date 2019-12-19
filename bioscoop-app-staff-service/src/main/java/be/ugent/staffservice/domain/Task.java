package be.ugent.staffservice.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private String location;
    private StaffType staffType;
    private int staffAmount;

    //next properties are importent when you want to regenerate tasks
    private String day; //movies after 12pm will have the same day.
    private LocalDateTime lastUpdate;
    private TaskGenerators generetedBy;


    public Task()
    {

    }


    public Task(String name, LocalDateTime beginDate, LocalDateTime endDate, String location, StaffType staffType, int staffAmount, String day, LocalDateTime lastUpdate, TaskGenerators generetedBy) {
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.location = location;
        this.staffType = staffType;
        this.staffAmount = staffAmount;
        this.day = day;
        this.lastUpdate = lastUpdate;
        this.generetedBy = generetedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }

    public int getStaffAmount() {
        return staffAmount;
    }

    public void setStaffAmount(int staffAmount) {
        this.staffAmount = staffAmount;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public TaskGenerators getGeneretedBy() {
        return generetedBy;
    }

    public void setGeneretedBy(TaskGenerators generetedBy) {
        this.generetedBy = generetedBy;
    }
}
