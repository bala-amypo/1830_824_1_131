package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.security.Timestamp;
@Entity 
public class DemandReading {
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
        this.zone = zone;
    }
    public Double getdemandMW() {
       return demandMW ;
    }
    public void setdemandMW(Double demanMW) {
        this.demandMW= demandMW;
    }
    public Timestamp getrecordedAt() {
      return recordedAt; 
    }
    public void setrecordedAt(Timestamp recordedAt) {
        this.recordedAt=recordedAt;
    }
    public DemandReading(Long id, String zone, Double demandMW, Timestamp recordedAt){
        this.id=id;
        this.zone=zone;
        this.demandMW= demandMW;
        this.recordedAt=recordedAt;
    }

    public DemandReading(){

    }
}