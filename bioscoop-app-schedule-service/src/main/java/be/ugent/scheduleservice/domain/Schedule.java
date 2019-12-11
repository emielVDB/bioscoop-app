package be.ugent.scheduleservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleId;

    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private int zaalNmr;
    private int eventId;
    private int mediaId;



    public Schedule()
    {

    }

    public Schedule(LocalDateTime beginDate,LocalDateTime endDate,int zaalNmr,int eventId,int mediaId)
    {
        this.beginDate=beginDate;
        this.endDate=endDate;
        this.zaalNmr=zaalNmr;
        this.eventId=eventId;
        this.mediaId=mediaId;
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
