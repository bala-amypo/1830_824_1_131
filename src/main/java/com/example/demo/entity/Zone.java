import lombok.*;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "zones")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String zoneName;
    
    @Column(nullable = false)
    private Integer priorityLevel;
    
    private Integer population;
    
    @Builder.Default
    private Boolean active = true;
    
    private Instant createdAt;
    private Instant updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
        if (active == null) {
            active = true;
        }
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
}