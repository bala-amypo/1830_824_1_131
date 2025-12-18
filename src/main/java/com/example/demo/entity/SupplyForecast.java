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
   
    private Double availableSupplyMW;
    private Timestamp forecastStart;
    private Timestamp forecastEnd;
    private Timestamp generatedAt;
    public long getId(int id) {
      return id;
    }
    public void setId(int id) {
        this.id= id;
    }
    public Double getavailableSupplyMW(Double availableSupplyMW) {
        return availableSupplyMW;
    }
    public void setavailableSupplyMW(Double availableSupplyMW) {
        this.availableSupplyMW = availableSupplyMW;
    }
    public Timestamp getforecastStart(Timestamp forecastStart ) {
       return forecastStart ;
    }
    public void setforecastStart(Timestamp forecastStart) {
        this.forecastStart= forecastStart;
    }
    public Timestamp getforecastEnd(Timestamp forecastEnd) {
        return forecastEnd;
    }
    public Timestamp setforecastEnd(Timestamp forecastEnd) {
        this.forecastEnd= forecastEnd;
    }
    public Timestamp getgeneratedAt(Timestamp generatedAt ) {
     return active;
    }
    public void setgeneratedAt(Timestamo generatedAt) {
        this.generatedAt= generatedAt;
    }
    
    public zone( long id,Double availableSupplyMW,Timestamp forecastStart,Timestamp forecastEnd,Timestamp generatedAt){
        this id = id;
        this availableSupplyMW = availableSupplyMW;
        this forecastStart = forecast
    }

    public zone(){
    }

}