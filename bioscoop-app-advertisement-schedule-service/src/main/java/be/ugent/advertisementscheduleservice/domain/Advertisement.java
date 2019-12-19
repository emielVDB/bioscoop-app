package be.ugent.advertisementscheduleservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int advertisementId;

    private int eventId;
    private Timestamp beginTime;
    private Timestamp endTime;
    private int mediaId;


    public Advertisement(int eventId, Timestamp beginTime, Timestamp endTime, int mediaId) {
        this.eventId = eventId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.mediaId = mediaId;
    }

    public Advertisement()
    {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }
}
