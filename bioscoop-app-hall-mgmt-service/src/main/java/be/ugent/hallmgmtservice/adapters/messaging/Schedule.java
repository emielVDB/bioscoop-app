package be.ugent.hallmgmtservice.adapters.messaging;


import java.time.LocalDateTime;

public class Schedule {

    private int eventId;

    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private int zaalNmr;
    private int mediaId;


    public Schedule()
    {

    }

    public Schedule(LocalDateTime beginDate, LocalDateTime endDate, int zaalNmr, int mediaId)
    {
        this.beginDate=beginDate;
        this.endDate=endDate;
        this.zaalNmr=zaalNmr;
        this.mediaId=mediaId;
    }


    public int getEventId() {
        return eventId;
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
