package be.ugent.advertisementscheduleservice.adapter.messaging;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {

    static final String ADDADSLOTS="AddAdSlots";
    static final String ADDADSLOTS_REPLY="AddAdSlotsReply";

    @Output(ADDADSLOTS_REPLY)
    MessageChannel AddAdSlotsReply();

    @Input(ADDADSLOTS)
    SubscribableChannel AddAdvertisementSlotsRequest();

}
