package be.ugent.consumptionservice.adapters;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {
    static final String ORDER_CONSUMPTIONS = "book_consumptions";
    static final String CONSUMPTIONS_ORDERED = "booked_consumptions";
    static final String DELETE_ORDERED_CONSUMPTIONS = "delete_booked_consumptions";

    @Input(ORDER_CONSUMPTIONS)
    SubscribableChannel orderConsumptions();

    @Output(CONSUMPTIONS_ORDERED)
    MessageChannel consumptionsOrdered();

    @Input(DELETE_ORDERED_CONSUMPTIONS)
    SubscribableChannel deleteOrderedConsumptions();
}
