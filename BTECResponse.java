package com.example.emeraldopendayapp;

import com.google.gson.annotations.SerializedName;

public class BTECResponse {
    @SerializedName("BTECID")
    private Integer btecID;

    @SerializedName("max_grade_btec")
    private String maxGrade;

    @SerializedName("min_grade_btec")
    private String minGrade;

    public BTECResponse(Integer btecID, String minGrade, String maxGrade) {
        this.maxGrade = maxGrade;
        this.minGrade = minGrade;
    }


    public Integer getBTECID() { return btecID; }

    public String getMaxGrade() { return maxGrade; }

    public String getMinGrade() { return minGrade; }
}
