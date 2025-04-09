package com.example.emeraldopendayapp;

import com.google.gson.annotations.SerializedName;

public class ModuleDegreeResponse {

    @SerializedName("ModulesDegreeID")
    private Integer moduleDegreeID;

    @SerializedName("deg_degreeid")
    private DegreeResponse degreeMDId;

    @SerializedName("modules_moduleid")
    private ModulesResponse moduleMDId;


    public ModuleDegreeResponse(Integer moduleDegreeID, DegreeResponse degreeMDId, ModulesResponse moduleMDId) {
        this.degreeMDId = degreeMDId;
        this.moduleMDId = moduleMDId;
    }

    public Integer getModuleDegreeID() {return moduleDegreeID;}
    public DegreeResponse getDegreeMDId() {return degreeMDId;}
    public ModulesResponse getModuleMDId() {return moduleMDId;}
}
