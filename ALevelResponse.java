package com.example.emeraldopendayapp;

import com.google.gson.annotations.SerializedName;

public class ALevelResponse {

    @SerializedName("ALevelID")
    private Integer alevelID;

    @SerializedName("max_grade")
    private String maxGrade;

    @SerializedName("min_grade")
    private String minGrade;

    public ALevelResponse(Integer alevelID, String maxGrade, String minGrade) {
        this.maxGrade = maxGrade;
        this.minGrade = minGrade;
    }


    public Integer getAlevelID() { return alevelID; }

    public String getMaxGrade() { return minGrade; }

    public String getMinGrade() { return maxGrade; }

}
