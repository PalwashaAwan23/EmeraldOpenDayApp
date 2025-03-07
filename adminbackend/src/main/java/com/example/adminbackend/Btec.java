package com.example.adminbackend;

import jakarta.persistence.*;

@Entity
@Table(name = "btec")
public class Btec{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BTECID")
    private Integer btecID;

    @Column(name = "max_grade_btec",nullable = false, length = 50)
    private String maxGrade;

    @Column(name = "min_grade_btec",nullable = false, length = 50)
    private String minGrade;

    public Btec() {}

    public Btec(Integer btecID, String maxGrade, String minGrade) {this.btecID = btecID;this.maxGrade = maxGrade;this.minGrade = minGrade;}

    public Integer getBtecID() {return btecID;}
    public void setBtecID(Integer btecID) {this.btecID = btecID;}

    public String getMaxGrade() {return maxGrade;}
    public void setMaxGrade(String maxGrade) {this.maxGrade = maxGrade;}

    public String getMinGrade() {return minGrade;}
    public void setMinGrade(String minGrade) {this.minGrade = minGrade;}
}