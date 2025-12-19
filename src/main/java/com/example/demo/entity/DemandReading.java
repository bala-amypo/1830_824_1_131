package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.security.Timestamp;
@Entity 
public class Zone {
    @Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String zone;
    private Double demandMW;
    private Timestamp recordedAt;
   
    public long getId() {
      return id;
    }
    public void setId(int id) {
        this.id= id;
    }
    public String getzone() {
        return zone;
    }
    public void setzone(String zone) {
        this.zoneName = zone;
    }
    public Double getdemandMW() {
       return demandMW ;
    }
    public void setdemandMW() {
        this.priorityLevel= priorityLevel;
    }
    public Integer getpopulation() {
        return population ;
    }
    public void setpopulation(Integer population) {
        this.population= population;
    }
    public Boolean getactive() {
     return active;
    }
    public void setactive(Boolean active) {
        this.active= active;
    }
    public Timestamp getcreatedAt() {
      return createdAt; 
    }
    public void setcreatedAt(Timestamp createdAt) {
        this.createdAt= createdAt;
    }
    public Timestamp getupdatedAt() {
      return updatedAt;
    }
    public void setupdatedAt(Timestamp updatedAt) {
        this.updatedAt= updatedAt;
    }

    public Zone(Long id, String zoneName, Integer priorityLevel, Integer population, Boolean active, Timestamp createdAt, Timestamp updatedAt){
        this.id=id;
        this.zoneName=zoneName;
        this.priorityLevel= priorityLevel;
        this.population=population;
        this.active=active;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
    }

    public Zone(){

    }
}