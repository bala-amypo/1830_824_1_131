package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SupplyForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalSupply;
    private Double renewableSupply;
    private Double demandForecast;

    private LocalDateTime forecastTime;

   
    public SupplyForecast() {}

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(Double totalSupply) {
        this.totalSupply = totalSupply;
    }

    public Double getRenewableSupply() {
        return renewableSupply;
    }

    public void setRenewableSupply(Double renewableSupply) {
        this.renewableSupply = renewableSupply;
    }

    public Double getDemandForecast() {
        return demandForecast;
    }

    public void setDemandForecast(Double demandForecast) {
        this.demandForecast = demandForecast;
    }

    public LocalDateTime getForecastTime() {
        return forecastTime;
    }

    public void setForecastTime(LocalDateTime forecastTime) {
        this.forecastTime = forecastTime;
    }
}
