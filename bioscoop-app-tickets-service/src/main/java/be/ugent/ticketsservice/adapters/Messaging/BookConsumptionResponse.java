package be.ugent.ticketsservice.adapters.Messaging;

import be.ugent.ticketsservice.domain.Consumption;

import java.util.List;

public class BookConsumptionResponse {
    private Long ticketid;
    private int eventid;
    private Long purchaseid;
    private List<Consumption> consumptions;

    public BookConsumptionResponse(Long ticketid, int eventid, Long purchaseid,List<Consumption> consumptions) {
        this.ticketid = ticketid;
        this.eventid = eventid;
        this.purchaseid=purchaseid;
        this.consumptions = consumptions;
    }

    public Long getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(Long purchaseid) {
        this.purchaseid = purchaseid;
    }

    public Long getTicketid() {
        return ticketid;
    }

    public void setTicketid(Long ticketid) {
        this.ticketid = ticketid;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public List<Consumption> getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(List<Consumption> consumptions) {
        this.consumptions = consumptions;
    }
}
