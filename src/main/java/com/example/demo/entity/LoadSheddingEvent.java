import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(name = "load_shedding_event")
public class LoadSheddingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @NotNull
    @Column(name = "event_start", nullable = false)
    private Instant eventStart;

    @NotNull
    @Column(name = "event_end", nullable = false)
    private Instant eventEnd;

    @Column(name = "reason")
    private String reason;

    @Column(name = "triggered_by_forecast_id")
    private Long triggeredByForecastId;

    @Min(0)
    @Column(name = "expected_demand_reduction_mw", nullable = false)
    private Double expectedDemandReductionMW;

    public LoadSheddingEvent() {
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

    public Instant getEventStart() {
        return eventStart;
    }

    public void setEventStart(Instant eventStart) {
        this.eventStart = eventStart;
    }

    public Instant getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(Instant eventEnd) {
        this.eventEnd = eventEnd;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getTriggeredByForecastId() {
        return triggeredByForecastId;
    }

    public void setTriggeredByForecastId(Long triggeredByForecastId) {
        this.triggeredByForecastId = triggeredByForecastId;
    }

    public Double getExpectedDemandReductionMW() {
        return expectedDemandReductionMW;
    }

    public void setExpectedDemandReductionMW(Double expectedDemandReductionMW) {
        this.expectedDemandReductionMW = expectedDemandReductionMW;
    }
}
