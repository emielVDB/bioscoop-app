package be.ugent.ticketsservice.adapters.Messaging;

import be.ugent.ticketsservice.domain.Consumption;

import java.util.List;

public class BookConsumptionResponse {
    private Long ticketid;
    private int eventid;
    private List<Consumption> consumptions;

    public BookConsumptionResponse(Long ticketid, int eventid, List<Consumption> consumptions) {
        this.ticketid = ticketid;
        this.eventid = eventid;
        this.consumptions = consumptions;
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
