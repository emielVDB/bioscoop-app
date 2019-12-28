package be.ugent.scheduleservice.domain;

public class ScheduleWithAdTime {

    Schedule schedule;
    int seconds=600;

    public ScheduleWithAdTime(Schedule schedule, int seconds) {
        this.schedule = schedule;
        this.seconds = seconds;
    }



    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
