import java.time.Instant;

@Column(name = "created_at")
private Instant createdAt;

@Column(name = "updated_at")
private Instant updatedAt;

public Instant getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
}

public Instant getUpdatedAt() {
    return updatedAt;
}

public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
}
