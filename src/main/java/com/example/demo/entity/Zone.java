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
    @Column(unique=true)
    private String zoneName;
    private Integer priorityLevel;
    private Integer population;
    private Boolean active;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    public long getId() {
      return id;
    }
    public void setId(int id) {
        this.id= id;
    }
    public String getzoneName() {
        return zoneName;
    }
    public void setzoneName(String zoneName) {
        this.zoneName = zoneName;
    }
    public Integer getpriorityLevel() {
       return priorityLevel ;
    }
    public void setpriorityLevel(Integer priorityLevel) {
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
    public Timestamp getcreateAt() {
      return createdAt; 
    }
    public void setcreateAt(Timestamp createdAt) {
        this.createdAt= createdAt;
    }
    public Timestamp getupdateAt() {
      return updateAt;
    }
    public void setupdateAt(Timestamp updateAt) {
        this.updateAt= updateAt;
    }

    public Zone(Long id, String zoneName, Integer priorityLevel, Integer population, Boolean active, Timestamp createdAt, Timestamp updatedAt){
        this.id=id;
        this.zoneName=zoneName;
        this.priorityLevel= priorityLevel;
        this.popultion=population;
        this.active=active;
        this.createAt=createAt;
        this.updatedAt=updateAt;
    }

    public Zone(){

    }
}