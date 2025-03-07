package com.example.adminbackend;

import jakarta.persistence.*;

import java.util.List;
import lombok.*;

@Entity
@Table(name = "alevel")
public class ALevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ALevelID")
    private Integer alevelID;

    @Column(name = "max_grade", nullable = false, length = 50)
    private String maxGrade;

    @Column(name = "min_grade", nullable = false, length = 50)
    private String minGrade;

    public ALevel() {}

    public ALevel(Integer alevelID, String maxGrade, String minGrade) {this.alevelID = alevelID; this.maxGrade = maxGrade; this.minGrade = minGrade;}

    public Integer getAlevelID() {return alevelID;}
    public void setAlevelID(Integer alevelID) {this.alevelID = alevelID;}

    public String getMaxGrade() {return maxGrade;}
    public void setMaxGrade(String maxGrade) {this.maxGrade = maxGrade;}

    public String getMinGrade() {return minGrade;}
    public void setMinGrade(String minGrade) {this.minGrade = minGrade;}
}