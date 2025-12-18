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
    public void setzoneName(String zoneName) {
        this.availableSupplyMW = ;
    }
    public Integer getpriorityLevel(Integer priorityLevel ) {
       return priorityLevel ;
    }
    public void setpriorityLevel(Integer priorityLevel) {
        this.priorityLevel= priorityLevel;
    }
    public Integer getpopulation(Integer population ) {
        return population ;
    }
    public void setpopulation(Integer population) {
        this.population= population;
    }
    public Boolean getactive(Boolean active ) {
     return active;
    }
    public void setactive(Boolean active) {
        this.active= active;
    }
    public Timestamp getcreateAt(Timestamp createdAt ) {
      return createdAt; 
    }
    public void setcreateAt(Timestamp createdAt) {
        this.createdAt= createdAt;
    }
    public Timestamp getupdateAt(Timestamp updateAt ) {
      return updateAt;
    }
    public void setupdateAt(Timestamp updateAt) {
        this.updateAt= updateAt;
    }

    public zone(Long id, String zoneName, Integer priorityLevel, Integer population, Boolean active, Timestamp createdAt, Timestamp updatedAt){
        this.id=id;
        this.zoneName=zoneName;
        this.priorityLevel= priorityLevel;
        this.popultion=population;
        this.active=active;
        this.createAt=createAt;
        this.updatedAt=updateAt;
    }

    public zone(){
    }

}