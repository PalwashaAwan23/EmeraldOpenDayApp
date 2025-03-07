package com.example.adminbackend;

import jakarta.persistence.*;

@Entity
@Table(name = "ocr")
public class Ocr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OCRCaID")
    private Integer ocrCaID;

    @Column(name = "max_grade_ocr", nullable = false, length = 50)
    private String maxGrade;

    @Column(name = "min_grade_ocr", nullable = false, length = 50)
    private String minGrade;

    public Ocr() {}

    public Ocr(Integer ocrCaID, String maxGrade, String minGrade) {this.ocrCaID = ocrCaID; this.maxGrade = maxGrade; this.minGrade = minGrade;}

    public Integer getOcrCaID() {return ocrCaID;}
    public void setOcrCaID(Integer ocrCaID) {this.ocrCaID = ocrCaID;}

    public String getMaxGrade() {return maxGrade;}
    public void setMaxGrade(String maxGrade) {this.maxGrade = maxGrade;}

    public String getMinGrade() {return minGrade;}
    public void setMinGrade(String minGrade) {this.minGrade = minGrade;}
}