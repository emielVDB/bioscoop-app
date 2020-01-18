package be.ugent.advertisementscheduleservice.domain;


import javax.persistence.*;

@Entity
@Table(name="ReservedAdvertisements")
public class ReservedAdvertisements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn//(name="advertisementId", nullable=false)
    private AdvertisementSlots advertisementSlots;

    private int mediaId=-1;

    public ReservedAdvertisements(int mediaId) {
        this.mediaId = mediaId;
    }

    public ReservedAdvertisements() {
    }

    public int getId() {
        return id;
    }

    public void setAdvertisementSlots(AdvertisementSlots advertisementSlots) {
        this.advertisementSlots = advertisementSlots;
    }

    public AdvertisementSlots getAdvertisementSlots() {
        return advertisementSlots;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }
}
