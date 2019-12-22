package be.ugent.consumptionservice.adapters;

import be.ugent.consumptionservice.domain.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderConsumptions {
    private int ticketid;
    private int eventid;
    private long purchaseid;
    private List<Product> consumptions;

    public OrderConsumptions(){}

    public OrderConsumptions(int ticketid, int eventid, long purchaseid, List<Product> consumptions) {
        this.ticketid = ticketid;
        this.eventid = eventid;
        this.purchaseid = purchaseid;
        this.consumptions = consumptions;
    }

    public long getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(long purchaseid) {
        this.purchaseid = purchaseid;
    }

    public int getTicketid() {
        return ticketid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public List<Product> getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(List<Product> consumptions) {
        this.consumptions = consumptions;
    }
}
