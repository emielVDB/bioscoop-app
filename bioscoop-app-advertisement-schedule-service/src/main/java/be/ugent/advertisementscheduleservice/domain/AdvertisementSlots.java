package be.ugent.advertisementscheduleservice.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name="AdvertisementSlots")
public class AdvertisementSlots {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int advertisementId;
    private int eventId;
    private int adSpace;
    @OneToMany(mappedBy="advertisementSlots", cascade = CascadeType.ALL)
    private Set<ReservedAdvertisements> reservedAdvertisementsSet;


    public AdvertisementSlots(int eventId, int adSpace,ReservedAdvertisements... reservedAdvertisementsSet) {
        this.eventId = eventId;
        this.adSpace = adSpace;
        this.reservedAdvertisementsSet = Stream.of(reservedAdvertisementsSet).collect(Collectors.toSet());
        this.reservedAdvertisementsSet.forEach(x -> x.setAdvertisementSlots(this));
    }

    public AdvertisementSlots()
    {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getAdSpace() {
        return adSpace;
    }

    public void setAdSpace(int adSpace) {
        this.adSpace = adSpace;
    }

    public Set<ReservedAdvertisements> getReservedAdvertisementsSet() {
        return reservedAdvertisementsSet;
    }

    public void setReservedAdvertisementsSet(Set<ReservedAdvertisements> reservedAdvertisementsSet) {
        this.reservedAdvertisementsSet = reservedAdvertisementsSet;
    }
}
