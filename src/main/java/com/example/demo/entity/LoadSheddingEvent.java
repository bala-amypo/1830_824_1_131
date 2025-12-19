package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.security.Timestamp;
@Entity 
public class SupplyForecast {
    @Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
   
    private String zone;
    private String reason;
    private Timestamp eventStart;
    private Timestamp evenEnd;
    private long triggeredByForecastId;
    private Double expectedDemandReductionMW;
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
    public Timestamp geteventStart() {
       return eventstart ;
    }
    public void seteventStart(Timestamp eventStart) {
        this.eventStart= evenStart;
    }
    public Timestamp geteventEnd() {
        return eventEnd;
    }
    public void seteventEnd(Timestamp eventEnd) {
        this.eventEnd= eventEnd;
    }
    public String getreason() {
     return reason;
    }
    public void setreason(Timestamp reason) {
        this.reason= generatedAt;
    }
    
    public SupplyForecast( long id,Double availableSupplyMW,Timestamp forecastStart,Timestamp forecastEnd,Timestamp generatedAt){
        this.id = id;
        this.availableSupplyMW = availableSupplyMW;
        this.forecastStart = forecastStart;
        this.forecastEnd = forecastEnd;
        this.generatedAt = generatedAt;
    }

    public SupplyForecast(){
    }

}
