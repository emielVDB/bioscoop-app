package be.ugent.staffservice.domain;

import java.time.LocalDateTime;

public class Event {
     private LocalDateTime beginDate;
     private LocalDateTime endDate;
     private EventType eventType;
     private int zaalNmr;

    public Event() {
    }

    public Event(LocalDateTime beginDate, LocalDateTime endDate, EventType eventType, int zaalNmr) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.eventType = eventType;
        this.zaalNmr = zaalNmr;
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

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getZaalNmr() {
        return zaalNmr;
    }

    public void setZaalNmr(int zaalNmr) {
        this.zaalNmr = zaalNmr;
    }
}
