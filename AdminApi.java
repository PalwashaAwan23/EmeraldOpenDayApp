package com.example.emeraldopendayapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AdminApi {

    // Degree
    @GET("/admin/get/degree/id/{degreeId}")
    Call<DegreeResponse> getDegreeById(@Path("degreeId") Integer degreeId);

    @GET("/admin/get/degree/{degreeName}")
    Call<DegreeResponse> getDegreeByName(@Path("degreeName") String degreeName);

    @POST("/admin/add/degree")
    Call<DegreeResponse> addDegree(@Body DegreeResponse degree);

    @DELETE("/admin/remove/degree/id/{degreeId}")
    Call<Void> removeDegree(@Path("degreeId") int degreeId);

    @DELETE("/admin/remove/degree/name/{degreeName}")
    Call <Void> removeDegreeByName(@Path("degreeName") String degreeName);

    // ALevel
    @POST("/admin/add/alevel")
    Call <ALevelResponse> addALevel(@Body ALevelResponse alevel);

    @DELETE("/admin/remove/alevel/mingrade/{minGrade}")
    Call <Void> removeALevelByMinGrade(@Path("minGrade") String minGrade);

    @DELETE("/admin/remove/alevel/maxgrade/{maxGrade}")
    Call <Void> removeALevelByMaxGrade(@Path("maxGrade") String maxGrade);

    @DELETE("/admin/remove/alevel/id/{alevelId}")
    Call <Void> removeALevelByALevelID(@Path("alevelId") Integer alevelId);

    @GET("/admin/get/alevel/minGrade/{minGrade}")
    Call <ALevelResponse> getAlevelByMinGrade(@Path("minGrade") String minGrade);

    @GET("/admin/get/alevel/maxGrade/{maxGrade}")
    Call <ALevelResponse> getAlevelByMaxGrade(@Path("maxGrade") String maxGrade);

    @GET("/admin/get/alevel/id/{alevelId}")
    Call <ALevelResponse> getAlevelById(@Path("alevelId") Integer alevelId);


    //HeDiploma
    @POST("/admin/add/he")
    Call <HEDiplomaResponse> addHE(@Body HEDiplomaResponse heDiploma);

    @GET("/admin/get/he/minGrade/{minGrade}")
    Call <HEDiplomaResponse> getHEByMinGrade(@Path("minGrade") String minGrade);

    @GET("/admin/get/he/maxGrade/{maxGrade}")
    Call <HEDiplomaResponse> getHEByMaxGrade(@Path("maxGrade") String maxGrade);

    @GET("/admin/get/he/id/{heID}")
    Call <HEDiplomaResponse> getHEById(@Path("heID") int heID);

    @DELETE("/admin/remove/he/mingrade/{minGrade}")
    Call <Void> removeHEByMinGrade(@Path("minGrade") String minGrade);

    @DELETE("/admin/remove/he/maxgrade/{maxGrade}")
    Call <Void> removeHEByMaxGrade(@Path("maxGrade") String maxGrade);

    @DELETE("/admin/remove/he/id/{heID}")
    Call <Void> removeHEById(@Path("heID") int heID);



    // BTEC
    @POST("/admin/add/btec")
    Call <BTECResponse> addBTEC(@Body BTECResponse btec);

    @GET("/admin/get/btec/mingrade/{minGrade}")
    Call <BTECResponse> getBTECByMinGrade(@Path("minGrade") String minGrade);

    @GET("/admin/get/btec/maxgrade/{maxGrade}")
    Call <BTECResponse> getBTECByMaxGrade(@Path("maxGrade") String maxGrade);

    @GET("/admin/get/btec/id/{btecId}")
    Call <BTECResponse> getBTECById(@Path("btecId") Integer btecId);

    @DELETE("/admin/remove/btec/mingrade/{minGrade}")
    Call<Void> removeBTECByMinGrade(@Path("minGrade") String minGrade);

    @DELETE("/admin/remove/btec/maxgrade/{maxGrade}")
    Call<Void> removeBTECByMaxGrade(@Path("maxGrade") String maxGrade);

    @DELETE("/admin/remove/btec/id/{btecId}")
    Call<Void> removeBTECById(@Path("btecId") Integer btecId);


    // OCR
    @POST("/admin/add/ocr")
    Call<OCRResponse> addOCR(@Body OCRResponse ocr);

    @GET("/admin/get/ocr/mingrade/{minGrade}")
    Call<OCRResponse> getOCRByMinGrade(@Path("minGrade") String minGrade);

    @GET("/admin/get/ocr/maxgrade/{maxGrade}")
    Call<OCRResponse> getOCRByMaxGrade(@Path("maxGrade") String maxGrade);

    @GET("/admin/get/ocr/id/{ocrCaID}")
    Call<OCRResponse> getOCRById(@Path("ocrCaID") Integer ocrCaID);

    @DELETE("/admin/remove/ocr/mingrade/{minGrade}")
    Call<Void> removeOCRByMinGrade(@Path("minGrade") String minGrade);

    @DELETE("/admin/remove/ocr/maxgrade/{maxGrade}")
    Call<Void>  removeOCRByMaxGrade(@Path("maxGrade") String maxGrade);

    @DELETE("/admin/remove/ocr/id/{ocrCaID}")
    Call<Void>  removeOCRById(@Path("ocrCaID") Integer ocrCaID);


    //Modules
    @POST("/admin/add/modules")
    Call<ModulesResponse> addModule (@Body ModulesResponse module);

    @GET("/admin/get/modules/name/{moduleName}")
    Call<ModulesResponse> getModuleByName(@Path("moduleName") String moduleName);

    @GET("/admin/get/modules/id/{moduleId}")
    Call<ModulesResponse> getModuleById(@Path("moduleId") Integer moduleId);

    @DELETE("/admin/remove/modules/name/{moduleName}")
    Call<Void> removeModuleByName(@Path("moduleName") String moduleName);

    @DELETE("/admin/remove/modules/id/{moduleId}")
    Call<Void> removeModuleById(@Path("moduleId") Integer moduleId);


    //CareerInfo
    @POST("/admin/add/careerinfo")
    Call<CareerInfoResponse> addCareerInfo(@Body CareerInfoResponse careerinfo);

    @GET("/admin/get/careerinfo/name/{careerName}")
    Call <CareerInfoResponse> getCareerByName(@Path("careerName") String careerName);

    @GET("/admin/get/careerinfo/id/{careerId}")
    Call <CareerInfoResponse> getCareerById(@Path("careerId") Integer careerId);

    @DELETE("/admin/remove/careerinfo/name/{careerName}")
    Call <Void> removeCareerByName(@Path("careerName") String careerName);

    @DELETE("/admin/remove/careerinfo/id/{careerId}")
    Call <Void> removeCareerById(@Path("careerId") Integer careerId);



    // Modules Degree
    @POST("/admin/add/modulesdegree")
    Call <ModuleDegreeResponse> addModuleDegree(@Body ModuleDegreeResponse modulesDegree);

    @GET("/admin/get/modulesdegree/byModulesDegree/{modulesDegreeID}")
    Call <ModuleDegreeResponse> getModulesDegreeByID(@Path("modulesDegreeID") Integer modulesDegreeID);

    @GET("/admin/get/modulesdegree/byDegree/{degreeID}")
    Call <List<ModuleDegreeResponse>> getModulesDegreeByDegreeID(@Path("degreeID") Integer degreeID);

    @GET("/admin/get/modulesdegree/byModule/{moduleID}")
    Call <List<ModuleDegreeResponse>> getModulesDegreeByModuleID(@Path("moduleID") Integer moduleID);

    @DELETE("/admin/delete/modulesdegree/{moduleDegreeID}")
    Call <Void> deleteModuleDegreeByID(@Path("moduleDegreeID") Integer moduleDegreeID);

    @DELETE("/admin/delete/modulesdegree/byDegree/{degreeID}")
    Call <Void> deleteModuleDegreeByDegreeID(@Path("degreeID") Integer degreeID);

    @DELETE("/admin/delete/modulesdegree/byModule/{moduleID}")
    Call <Void> deleteModuleDegreeByModuleID(@Path("moduleID") Integer moduleID);

    // Career Degree

    @POST("/admin/add/careerdegree")
    Call <CareerDegreeResponse> addCareerDegree(@Body CareerDegreeResponse careerDegree);

    @GET("/admin/get/careerdegree/{careerDegreeID}")
    Call <CareerDegreeResponse> getCareerDegreeByID(@Path("careerDegreeID") Integer careerDegreeID);

    @GET("/admin/get/careerdegree/byDegree/{degreeID}")
    Call <List<CareerDegreeResponse>> getCareerDegreeByDegreeID(@Path("degreeID") Integer degreeID);

    @GET("/admin/get/careerdegree/byCareer/{careerID}")
    Call <List<CareerDegreeResponse>> getCareerDegreeByCareerID(@Path("careerID") Integer careerID);

    @DELETE("/admin/delete/careerdegree/{careerDegreeID}")
    Call <Void> deleteCareerDegreeByID(@Path("careerDegreeID") Integer careerDegreeID);

    @DELETE("/admin/delete/careerdegree/byDegree/{degreeID}")
    Call <Void> deleteCareerDegreeByDegreeID(@Path("degreeID") Integer degreeID);

    @DELETE("/admin/delete/careerdegree/byCareer/{careerID}")
    Call <Void> deleteCareerDegreeByCareerID(@Path("careerID") Integer careerID);


    // Entry Requirement
    @POST("/admin/add/entryrequirement")
    Call<EntryRequirementResponse> addEntryRequirement(@Body EntryRequirementResponse entryrequirement);
    @GET("/admin/get/entryrequirement/{requirementID}")
    Call<EntryRequirementResponse> getEntryRequirementByID(@Path("requirementID") Integer requirementID);
    @GET("/admin/get/entryrequirement/byDegree/{degreeId}")
    Call<List<EntryRequirementResponse>> getEntryRequirementByDegreeID(@Path("degreeID") Integer degreeId);
    @GET("/admin/get/entryrequirement/byAlevel/{alevelID}")
    Call<List<EntryRequirementResponse>> getEntryRequirementByALevelID(@Path("alevelID") Integer alevelID);
    @GET("/admin/get/entryrequirement/byBtec/{btecID}")
    Call<List<EntryRequirementResponse>> getEntryRequirementByBtecID(@Path("btecID") Integer btecID);
    @GET("/admin/get/entryrequirement/byOcr/{ocrCaID}")
    Call<List<EntryRequirementResponse>> getEntryRequirementByOcrCaID(@Path("ocrCaID") Integer ocrCaID);
    @GET("/admin/get/entryrequirement/byHeDiploma/{heID}")
    Call<List<EntryRequirementResponse>> getEntryRequirementByHeDiplomaID(@Path("heID") Integer heID);
    @DELETE("/admin/delete/entryrequirement/{requirementID}")
    Call<Void> deleteEntryRequirementByID(@Path("requirementID") Integer requirementID);
    @DELETE("/admin/delete/entryrequirement/byDegree/{degreeID}")
    Call<Void> deleteEntryRequirementByDegreeID(@Path("degreeID") Integer degreeID);
    @DELETE("/admin/delete/entryrequirement/byAlevel/{alevelID}")
    Call<Void> deleteEntryRequirementByALevelID(@Path("alevelID") Integer alevelID);
    @DELETE("/admin/delete/entryrequirement/byBtec/{btecID}")
    Call<Void> deleteEntryRequirementByBtecID(@Path("btecID") Integer btecID);
    @DELETE("/admin/delete/entryrequirement/byOcr/{ocrCaID}")
    Call<Void> deleteEntryRequirementByOcrCaID(@Path("ocrCaID") Integer ocrCaID);
    @DELETE("/admin/delete/entryrequirement/byHeDiploma/{heID}")
    Call<Void> deleteEntryRequirementByHeDiplomaID(@Path("heID") Integer heID);
}
