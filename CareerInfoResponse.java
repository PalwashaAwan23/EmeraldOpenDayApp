package com.example.emeraldopendayapp;

import com.google.gson.annotations.SerializedName;

public class CareerInfoResponse {

    @SerializedName("CareerID")
    private Integer careerId;
    @SerializedName("career_name")
    private String careerName;
    @SerializedName("starting_salary")
    private Integer startingSalary;
    @SerializedName("average_salary")
    private Integer averageSalary;

    public CareerInfoResponse(Integer careerId, String careerName, Integer startingSalary, Integer averageSalary) {
        this.careerName = careerName;
        this.startingSalary = startingSalary;
        this.averageSalary = averageSalary;
    }

    public Integer getCareerId() { return careerId;}
    public String getCareerName() { return careerName; }
    public Integer getStartingSalary() { return startingSalary; }
    public Integer getAverageSalary() { return averageSalary; }
}
