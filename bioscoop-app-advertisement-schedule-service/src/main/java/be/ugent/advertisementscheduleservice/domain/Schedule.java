package be.ugent.advertisementscheduleservice.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private EventType eventType;
    private int zaalNmr;
    private int mediaId;


    public Schedule()
    {

    }

    public Schedule(LocalDateTime beginDate, LocalDateTime endDate, int zaalNmr, int mediaId, EventType eventType)
    {
        this.beginDate=beginDate;
        this.endDate=endDate;
        this.zaalNmr=zaalNmr;
        this.mediaId=mediaId;
        this.eventType=eventType;
    }


    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
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

    public int getZaalNmr() {
        return zaalNmr;
    }

    public void setZaalNmr(int zaalNmr) {
        this.zaalNmr = zaalNmr;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }



}
