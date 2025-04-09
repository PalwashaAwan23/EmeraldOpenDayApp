package com.example.emeraldopendayapp;

import com.google.gson.annotations.SerializedName;

public class HEDiplomaResponse {
    @SerializedName("HEID")
    private Integer heID;

    @SerializedName("max_grade_he")
    private String maxGrade;

    @SerializedName("min_grade_he")
    private String minGrade;

    public HEDiplomaResponse(Integer heID, String maxGrade, String minGrade) {
        this.maxGrade = maxGrade;
        this.minGrade = minGrade;
    }


    public Integer getHeID() { return heID; }

    public String getMaxGrade() { return maxGrade; }

    public String getMinGrade() { return minGrade; }
}
