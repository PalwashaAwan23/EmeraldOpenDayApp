package com.example.emeraldopendayapp;

import com.google.gson.annotations.SerializedName;

public class ModulesResponse {

    @SerializedName("ModuleID")
    private Integer moduleId;

    @SerializedName("module_name")
    private String moduleName;

    @SerializedName("credits")
    private Integer credits;

    public ModulesResponse(Integer moduleId, String moduleName, Integer credits) {
        this.moduleName = moduleName;
        this.credits = credits;
    }

    public Integer getModuleId() { return moduleId; }
    public String getModuleName() { return moduleName; }
    public Integer getCredits() { return credits; }


}
