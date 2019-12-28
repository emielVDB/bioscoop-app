package be.ugent.hallmgmtservice.adapters.messaging;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReserveHallRequest {
    private int hallNumber;
    private int eventId;

    public ReserveHallRequest(){}

    public int getHallNumber(){return this.hallNumber;}
    public int getEventId(){return this.eventId;}
}