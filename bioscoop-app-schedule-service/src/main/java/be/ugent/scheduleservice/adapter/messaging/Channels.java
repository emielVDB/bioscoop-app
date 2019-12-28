package be.ugent.scheduleservice.adapter.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {




    static final String ADDADSLOTS="AddAdSlots";
    static final String ADDADSLOTS_REPLY="AddAdSlotsReply";

    static final String BOOKHALL="BookHall";
    static final String BOOKHALL_REPLY="BookHallReply";

    static final String GETHALLPROP="GetHallProp";
    static final String GETHALLPROP_REPLY="GetHallPropReply";

    static final String REMOVEADSLOT="RemoveAdsSlot";
    static final String REMOVEBOOKEDHALL="RemoveBookedHall";

    @Output(REMOVEADSLOT)
    MessageChannel RemoveAdsSlot();

    @Output(REMOVEBOOKEDHALL)
    MessageChannel RemoveBookedHall();


    @Output(ADDADSLOTS)
    MessageChannel AddAdvertisementSlots();


    @Output(BOOKHALL)
    MessageChannel BookHall();


    @Output(GETHALLPROP)
    MessageChannel GetHallProperties();


    @Input(GETHALLPROP_REPLY)
    SubscribableChannel GetHallPropReply();

    @Input(BOOKHALL_REPLY)
    SubscribableChannel BookHallReply();

    @Input(ADDADSLOTS_REPLY)
    SubscribableChannel AddAdSlotsReply();
}
