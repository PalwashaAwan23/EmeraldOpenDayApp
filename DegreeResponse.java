package com.example.emeraldopendayapp;

import com.google.gson.annotations.SerializedName;

public class DegreeResponse {
    @SerializedName("DegreeID")
    private Integer degreeId;
    @SerializedName("degree_name")
    private String degreeName;
    @SerializedName("course_length")
    private String courseLength;
    @SerializedName("UCASCode")
    private String UCASCode;

    public DegreeResponse(Integer degreeId, String degreeName, String ucasCode, String courseLength) {
        this.degreeName = degreeName;
        this.UCASCode = ucasCode;
        this.courseLength = courseLength;
    }

    public String getDegreeName() { return degreeName; }
    public String getCourseLength() { return courseLength; }
    public Integer getDegreeId() {return degreeId;}
    public String getUCASCode() {return UCASCode;}
}
