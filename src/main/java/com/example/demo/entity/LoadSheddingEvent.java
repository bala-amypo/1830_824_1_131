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
    public Double getavailableSupplyMW() {
        return availableSupplyMW;
    }
    public void setavailableSupplyMW(Double availableSupplyMW) {
        this.availableSupplyMW = availableSupplyMW;
    }
    public Timestamp getforecastStart() {
       return forecastStart ;
    }
    public void setforecastStart(Timestamp forecastStart) {
        this.forecastStart= forecastStart;
    }
    public Timestamp getforecastEnd() {
        return forecastEnd;
    }
    public void setforecastEnd(Timestamp forecastEnd) {
        this.forecastEnd= forecastEnd;
    }
    public Timestamp getgeneratedAt() {
     return generatedAt;
    }
    public void setgeneratedAt(Timestamp generatedAt) {
        this.generatedAt= generatedAt;
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
