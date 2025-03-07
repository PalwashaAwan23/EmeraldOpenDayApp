package com.example.adminbackend;

import jakarta.persistence.*;

@Entity
@Table(name = "he")
public class HEDiploma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HEID")
    private Integer heID;

    @Column(name = "max_grade_he", nullable = false, length = 50)
    private String maxGrade;

    @Column(name = "min_grade_he", nullable = false, length = 50)
    private String minGrade;

    public HEDiploma() {}

    public HEDiploma(Integer heID, String maxGrade, String minGrade) {this.heID = heID; this.maxGrade = maxGrade;this.minGrade = minGrade;}

    public Integer getHeID() {return heID;}
    public void setHeID(Integer heID) {this.heID = heID;}

    public String getMaxGrade() {return maxGrade;}
    public void setMaxGrade(String maxGrade) {this.maxGrade = maxGrade;}

    public String getMinGrade() {return minGrade;}
    public void setMinGrade(String minGrade) {this.minGrade = minGrade;}

}