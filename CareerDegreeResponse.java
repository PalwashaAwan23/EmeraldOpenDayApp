package com.example.emeraldopendayapp;

import com.google.gson.annotations.SerializedName;

public class CareerDegreeResponse {
    @SerializedName("CareerDegreeID")
    private Integer careerDegreeID;
    @SerializedName("degree_degID")
    private DegreeResponse degreeCDId;

    @SerializedName("careerinfo_careerid")
    private CareerInfoResponse careerInfoCDId;


    public CareerDegreeResponse(Integer careerDegreeID, DegreeResponse degreeCDId, CareerInfoResponse careerInfoCDId) {
        this.degreeCDId = degreeCDId;
        this.careerInfoCDId = careerInfoCDId;
    }

    public Integer getCareerDegreeID() {return careerDegreeID;}
    public DegreeResponse getDegreeCDId() {return degreeCDId;}
    public CareerInfoResponse getCareerInfoCDId() {return careerInfoCDId;}
}
