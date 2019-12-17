package be.ugent.hallmgmtservice.adapters.messaging;

class ReserveHallRequest {
    private int hallNumber;
    private int eventId;

    public int getHallNumber(){return this.hallNumber;}
    public int getEventId(){return this.eventId;}
}
