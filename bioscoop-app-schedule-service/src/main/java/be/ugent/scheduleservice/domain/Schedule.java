package be.ugent.scheduleservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Schedule {

    @Id
    private String scheduleId;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private int zaalNmr;
    private int eventId;
    private int mediaId;



    public Schedule()
    {

    }

    public Schedule(String scheduleId, LocalDateTime beginDate,LocalDateTime endDate,int zaalNmr,int eventId,int mediaId)
    {
        this.scheduleId=scheduleId;
        this.beginDate=beginDate;
        this.endDate=endDate;
        this.zaalNmr=zaalNmr;
        this.eventId=eventId;
        this.mediaId=mediaId;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
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

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }



}
