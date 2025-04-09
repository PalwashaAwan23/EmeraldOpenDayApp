package com.example.emeraldopendayapp;

import com.google.gson.annotations.SerializedName;

public class EntryRequirementResponse {

    @SerializedName("requiredID")
    private Integer requirementID;
    @SerializedName("ucas_points")
    private Integer ucasPoints;

    @SerializedName("degree_erid")
    private DegreeResponse degreeER;

    @SerializedName("alevel_erid")
    private ALevelResponse aLevel;
    @SerializedName("btec_erid")
    private BTECResponse btec;

    @SerializedName("ocr_erid")
    private OCRResponse ocr;

    @SerializedName("he_erid")
    private HEDiplomaResponse heD;



    public EntryRequirementResponse(Integer requirementID, Integer ucasPoints, DegreeResponse degree, ALevelResponse aLevel, BTECResponse btec, OCRResponse ocr, HEDiplomaResponse heD) {
        this.ucasPoints = ucasPoints;
        this.degreeER = degree;
        this.aLevel = aLevel;
        this.btec = btec;
        this.ocr = ocr;
        this.heD = heD;
    }

    public Integer getRequirementID() {return requirementID;}
    public Integer getUcasPoints() {return ucasPoints;}
    public DegreeResponse getDegreeER() {return degreeER;}
    public ALevelResponse getALevel() {return aLevel;}

    public BTECResponse getBtec() {return btec;}
    public OCRResponse getOcr() {return ocr;}
    public HEDiplomaResponse getHeD() {return heD;}

}
