package com.example.emeraldopendayapp;

import com.google.gson.annotations.SerializedName;

public class OCRResponse {

    @SerializedName("OCRCaID")
    private Integer ocrCaID;

    @SerializedName("max_grade_ocr")
    private String maxGrade;

    @SerializedName("min_grade_ocr")
    private String minGrade;

    public OCRResponse(Integer ocrCaID, String minGrade, String maxGrade) {
        this.maxGrade = maxGrade;
        this.minGrade = minGrade;
    }

    public Integer getOcrCaID() { return ocrCaID; }

    public String getMaxGrade() { return minGrade; }

    public String getMinGrade() { return maxGrade; }
}
