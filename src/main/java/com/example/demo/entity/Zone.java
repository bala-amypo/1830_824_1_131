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
    private Timestamp createAt;
    private Timestamp updatedAt;
    public long getId(int id) {
      return id;
    }
    public void setId(int id) {
        this.id= id;
    }
    public String getzoneName(String zoneName) {
        return zoneName;
    }
    public void setzoneName(String zoneName) {
        this.zoneName = zoneName;
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
    public Timestamp getcreateAt(Timestamp createAt ) {
      return createAt; 
    }
    public void setcreateAt(Timestamp createAt) {
        this.createAt= createAt;
    }
    public Timestamp getupdateAt(Timestamp updateAt ) {
      return updateAt;
    }
    public void setupdateAt(Timestamp updateAt) {
        this.updateAt= updateAt;
    }

    public  zone(long id, String zoneName, Integer priorityLevel, Integer population, Boolean active, Timestamp createAt, Timestamp updatedAt){
        this.id=id;
        this.priorityLevel= priorityLevel;
        this.popultion=population;
        this.active=active;
        this.createAt=createAt;
        this.updateAt=updateAt;


    }

    public zone(){

    }
}