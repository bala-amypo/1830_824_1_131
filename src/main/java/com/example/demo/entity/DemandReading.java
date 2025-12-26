import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.Instant;

@Entity
@Table(name = "demand_reading")
public class DemandReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @NotNull
    @Min(0)
    @Column(name = "demand_mw", nullable = false)
    private Double demandMW;

    @NotNull
    @PastOrPresent
    @Column(name = "recorded_at", nullable = false)
    private Instant recordedAt;

    public DemandReading() {
    }

    public Long getId() {
        return id;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Double getDemandMW() {
        return demandMW;
    }

    public void setDemandMW(Double demandMW) {
        this.demandMW = demandMW;
    }

    public Instant getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(Instant recordedAt) {
        this.recordedAt = recordedAt;
    }
}
