package com.example.adminbackend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private DegreeRepository degreeRepository;

    @PostMapping("/add/degree")
    public ResponseEntity<Degree> addDegree(@RequestBody Degree degree) {
        degreeRepository.save(degree);
        return ResponseEntity.ok(degree);
    }

    @GetMapping("/get/degree/{degreeName}")
    public ResponseEntity<Degree> getDegreeByName(@PathVariable String degreeName) {
        Degree getDegree = degreeRepository.findByDegreeName(degreeName);
        return getDegree != null ? ResponseEntity.ok(getDegree) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/degree/id/{degreeId}")
    public ResponseEntity<Degree> getDegreeById(@PathVariable Integer degreeId) {
        Degree degree = degreeRepository.findByDegreeId(degreeId);
        return degree != null ? ResponseEntity.ok(degree) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/remove/degree/name/{degreeName}")
    public ResponseEntity<Void> removeDegreeByName(@PathVariable String degreeName) {
        degreeRepository.removeDegreeByDegreeName(degreeName);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/degree/id/{degreeId}")
    public ResponseEntity<Void> removeDegreeById(@PathVariable Integer degreeId) {
        degreeRepository.removeDegreeByDegreeId(degreeId);
        return ResponseEntity.ok().build();
    }


    @Autowired
    private ModulesRepository modulesRepository;

    @PostMapping("/add/modules")
    public ResponseEntity<Modules> addModule (@RequestBody Modules module) {
        modulesRepository.save(module);
        return ResponseEntity.ok(module);
    }

    @GetMapping("/get/modules/{moduleName}")
    public ResponseEntity<Modules> getModuleByName(@PathVariable String moduleName) {
        Modules getModule = modulesRepository.findByModuleName(moduleName);
        return getModule != null ? ResponseEntity.ok(getModule) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/modules/id/{moduleId}")
    public ResponseEntity<Modules> getModuleById(@PathVariable Integer moduleId) {
        Modules module = modulesRepository.findByModuleId(moduleId);
        return module != null ? ResponseEntity.ok(module) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/remove/modules/name/{moduleName}")
    public ResponseEntity<Void> removeModuleByName(@PathVariable String moduleName) {
        modulesRepository.removeModuleByModuleName(moduleName);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/modules/id/{moduleId}")
    public ResponseEntity<Void> removeModuleById(@PathVariable Integer moduleId) {
        modulesRepository.removeModuleByModuleId(moduleId);
        return ResponseEntity.ok().build();
    }


    @Autowired
    private CareerInfoRepository careerInfoRepository;

    @PostMapping("/add/careerinfo")
    public ResponseEntity<CareerInfo> addCareer (@RequestBody CareerInfo career) {
        careerInfoRepository.save(career);
        return ResponseEntity.ok(career);
    }

    @GetMapping("/get/careerinfo/{careerName}")
    public ResponseEntity<CareerInfo> getCareerByName(@PathVariable String careerName) {
        CareerInfo getCareer = careerInfoRepository.findByCareerName(careerName);
        return getCareer != null ? ResponseEntity.ok(getCareer) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/careerinfo/id/{careerId}")
    public ResponseEntity<CareerInfo> getCareerById(@PathVariable Integer careerId) {
        CareerInfo career = careerInfoRepository.findByCareerId(careerId);
        return career != null ? ResponseEntity.ok(career) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/remove/careerinfo/name/{careerName}")
    public ResponseEntity<Void> removeCareerByName(@PathVariable String careerName) {
        careerInfoRepository.removeCareerByCareerName(careerName);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/careerinfo/id/{careerId}")
    public ResponseEntity<Void> removeCareerById(@PathVariable Integer careerId) {
        careerInfoRepository.removeCareerByCareerId(careerId);
        return ResponseEntity.ok().build();
    }


    @Autowired
    private ALevelRepository aLevelRepository;

    @PostMapping("/add/alevel")
    public ResponseEntity<ALevel> addCareer (@RequestBody ALevel alevel) {
        aLevelRepository.save(alevel);
        return ResponseEntity.ok(alevel);
    }

    @GetMapping("/get/alevel/{minGrade}")
    public ResponseEntity<ALevel> getAlevelByMinGrade(@PathVariable String minGrade) {
        ALevel aLevel = aLevelRepository.findByAlevelMinGrade(minGrade);
        return aLevel != null ? ResponseEntity.ok(aLevel) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/alevel/{maxGrade}")
    public ResponseEntity<ALevel> getAlevelByMaxGrade(@PathVariable String maxGrade) {
        ALevel aLevel = aLevelRepository.findByAlevelMaxGrade(maxGrade);
        return aLevel != null ? ResponseEntity.ok(aLevel) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/alevel/id/{alevelId}")
    public ResponseEntity<ALevel> getAlevelById(@PathVariable Integer alevelId) {
        ALevel aLevel = aLevelRepository.findByAlevelId(alevelId);
        return aLevel != null ? ResponseEntity.ok(aLevel) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/remove/alevel/mingrade/{minGrade}")
    public ResponseEntity<Void> removeAlevelByMinGrade(@PathVariable String minGrade) {
        aLevelRepository.removeAlevelByMinGrade(minGrade);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/alevel/maxgrade/{maxGrade}")
    public ResponseEntity<Void> removeAlevelByMaxGrade(@PathVariable String maxGrade) {
        aLevelRepository.removeAlevelByMaxGrade(maxGrade);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/alevel/id/{alevelId}")
    public ResponseEntity<Void> removeAlevelById(@PathVariable Integer alevelId) {
        aLevelRepository.removeALevelByAlevelID(alevelId);
        return ResponseEntity.ok().build();
    }


    @Autowired
    private BtecRepository btecRepository;

    @PostMapping("/add/btec")
    public ResponseEntity<Btec> addBTEC (@RequestBody Btec btec) {
        btecRepository.save(btec);
        return ResponseEntity.ok(btec);
    }

    @GetMapping("/get/btecexdipl/{minGrade}")
    public ResponseEntity<Btec> getBTECByMinGrade(@PathVariable String minGrade) {
        Btec btec = btecRepository.findByBTECMinGrade(minGrade);
        return btec != null ? ResponseEntity.ok(btec) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/btecexdipl/{maxGrade}")
    public ResponseEntity<Btec> getBTECByMaxGrade(@PathVariable String maxGrade) {
        Btec btec = btecRepository.findByBTECMinGrade(maxGrade);
        return btec != null ? ResponseEntity.ok(btec) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/btecexdipl/id/{btecId}")
    public ResponseEntity<Btec> getBTECById(@PathVariable Integer btecId) {
        Btec Btec = btecRepository.findByBTECId(btecId);
        return Btec != null ? ResponseEntity.ok(Btec) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/remove/btecexdipl/mingrade/{minGrade}")
    public ResponseEntity<Void> removeBTECByMinGrade(@PathVariable String minGrade) {
        btecRepository.removeBTECByMinGrade(minGrade);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/btecexdipl/maxgrade/{maxGrade}")
    public ResponseEntity<Void> removeBTECByMaxGrade(@PathVariable String maxGrade) {
        btecRepository.removeBTECByMaxGrade(maxGrade);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/btecexdipl/id/{btecId}")
    public ResponseEntity<Void> removeBTECById(@PathVariable Integer btecId) {
        btecRepository.removeBTECByAlevelID(btecId);
        return ResponseEntity.ok().build();
    }


    @Autowired
    private OcrRepository ocrRepository;

    @PostMapping("/add/ocr")
    public ResponseEntity<Ocr> addOCR (@RequestBody Ocr ocr) {
        ocrRepository.save(ocr);
        return ResponseEntity.ok(ocr);
    }

    @GetMapping("/get/ocr/{minGrade}")
    public ResponseEntity<Ocr> getOCRByMinGrade(@PathVariable String minGrade) {
        Ocr OCR = ocrRepository.findOCRByMinGrade(minGrade);
        return OCR != null ? ResponseEntity.ok(OCR) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/ocr/{maxGrade}")
    public ResponseEntity<Ocr> getOCRByMaxGrade(@PathVariable String maxGrade) {
        Ocr OCR = ocrRepository.findOCRByMaxGrade(maxGrade);
        return OCR != null ? ResponseEntity.ok(OCR) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/ocr/id/{ocrCaID}")
    public ResponseEntity<Ocr> getOCRById(@PathVariable Integer ocrCaID) {
        Ocr ocr = ocrRepository.findByOCRId(ocrCaID);
        return ocr != null ? ResponseEntity.ok(ocr) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/remove/ocr/mingrade/{minGrade}")
    public ResponseEntity<Void> removeOCRByMinGrade(@PathVariable String minGrade) {
        ocrRepository.removeOCRByMinGrade(minGrade);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/ocr/maxgrade/{maxGrade}")
    public ResponseEntity<Void> removeOCRByMaxGrade(@PathVariable String maxGrade) {
        ocrRepository.removeOCRByMaxGrade(maxGrade);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/ocr/id/{ocrCaID}")
    public ResponseEntity<Void> removeOCRById(@PathVariable Integer ocrCaID) {
        ocrRepository.removeOCRByOCRID(ocrCaID);
        return ResponseEntity.ok().build();
    }


    @Autowired
    private HEDiplomaRepository hediplomaRepository;

    @PostMapping("/add/he")
    public ResponseEntity<HEDiploma> addHE (@RequestBody HEDiploma hediploma) {
        hediplomaRepository.save(hediploma);
        return ResponseEntity.ok(hediploma);
    }

    @GetMapping("/get/he/{minGrade}")
    public ResponseEntity<HEDiploma> getHEByMinGrade(@PathVariable String minGrade) {
        HEDiploma heDiploma= hediplomaRepository.findByHEMinGrade(minGrade);
        return heDiploma != null ? ResponseEntity.ok(heDiploma) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/he/{maxGrade}")
    public ResponseEntity<HEDiploma> getHEByMaxGrade(@PathVariable String maxGrade) {
        HEDiploma heDiploma = hediplomaRepository.findByHEMaxGrade(maxGrade);
        return heDiploma != null ? ResponseEntity.ok(heDiploma) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/ocr/id/{heID}")
    public ResponseEntity<HEDiploma> getHEById(@PathVariable Integer heID) {
        HEDiploma heDiploma = hediplomaRepository.findByHEID(heID);
        return heDiploma != null ? ResponseEntity.ok(heDiploma) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/remove/he/mingrade/{minGrade}")
    public ResponseEntity<Void> removeHEByMinGrade(@PathVariable String minGrade) {
        hediplomaRepository.removeHEByMinGrade(minGrade);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/he/maxgrade/{maxGrade}")
    public ResponseEntity<Void> removeHEByMaxGrade(@PathVariable String maxGrade) {
        hediplomaRepository.removeHEByMaxGrade(maxGrade);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/he/id/{heID}")
    public ResponseEntity<Void> removeHEById(@PathVariable Integer heID) {
        hediplomaRepository.removeHEByHEID(heID);
        return ResponseEntity.ok().build();
    }


    @Autowired
    private CareerDegreeRepository careerDegreeRepository;

    @PostMapping("/add/careerdegree")
    public ResponseEntity<CareerDegree> addCareerDegree(@RequestBody CareerDegree careerDegree) {
        careerDegreeRepository.save(careerDegree);
        return ResponseEntity.ok(careerDegree);
    }

    @GetMapping("/get/careerdegree/{careerDegreeID}")
    public ResponseEntity<CareerDegree> getCareerDegreeByID(@PathVariable Integer careerDegreeID) {
        CareerDegree careerDegree = careerDegreeRepository.findByCareerDegreeID(careerDegreeID);
        return careerDegree != null ? ResponseEntity.ok(careerDegree) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/careerdegree/byDegree/{degreeID}")
    public ResponseEntity<List<CareerDegree>> getCareerDegreeByDegreeID(@PathVariable Integer degreeID) {
        List<CareerDegree> careerDegrees = careerDegreeRepository.findByDegreeID(degreeID);
        return careerDegrees.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(careerDegrees);
    }

    @GetMapping("/get/careerdegree/byCareer/{careerID}")
    public ResponseEntity<List<CareerDegree>> getCareerDegreeByCareerID(@PathVariable Integer careerID) {
        List<CareerDegree> careerDegrees = careerDegreeRepository.findByCareerID(careerID);
        return careerDegrees.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(careerDegrees);
    }

    @DeleteMapping("/delete/careerdegree/{careerDegreeID}")
    public ResponseEntity<Void> deleteCareerDegreeByID(@PathVariable Integer careerDegreeID) {
        careerDegreeRepository.deleteByCareerDegreeID(careerDegreeID);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/careerdegree/byDegree/{degreeID}")
    public ResponseEntity<Void> deleteCareerDegreeByDegreeID(@PathVariable Integer degreeID) {
        careerDegreeRepository.deleteByDegreeID(degreeID);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/careerdegree/byCareer/{careerID}")
    public ResponseEntity<Void> deleteCareerDegreeByCareerID(@PathVariable Integer careerID) {
        careerDegreeRepository.deleteByCareerID(careerID);
        return ResponseEntity.ok().build();
    }


    @Autowired
    private ModulesDegreeRepository modulesDegreeRepository;

    @PostMapping("/add/modulesdegree")
    public ResponseEntity<ModulesDegree> addModuleDegree(@RequestBody ModulesDegree modulesDegree) {
        modulesDegreeRepository.save(modulesDegree);
        return ResponseEntity.ok(modulesDegree);
    }

    @GetMapping("/get/modulesdegree/{modulesDegreeID}")
    public ResponseEntity<ModulesDegree> getModulesDegreeByID(@PathVariable Integer modulesDegreeID) {
        ModulesDegree modulesDegree = modulesDegreeRepository.findByModuleDegreeID(modulesDegreeID);
        return modulesDegree != null ? ResponseEntity.ok(modulesDegree) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/modulesdegree/byDegree/{degreeID}")
    public ResponseEntity<List<ModulesDegree>> getModulesDegreeByDegreeID(@PathVariable Integer degreeID) {
        List<ModulesDegree> modulesDegrees = modulesDegreeRepository.findByDegreeID(degreeID);
        return modulesDegrees.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(modulesDegrees);
    }

    @GetMapping("/get/modulesdegree/byModule/{moduleID}")
    public ResponseEntity<List<ModulesDegree>> getModulesDegreeByModuleID(@PathVariable Integer moduleID) {
        List<ModulesDegree> modulesDegrees = modulesDegreeRepository.findByModuleID(moduleID);
        return modulesDegrees.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(modulesDegrees);
    }

    @DeleteMapping("/delete/modulesdegree/{moduleDegreeID}")
    public ResponseEntity<Void> deleteModuleDegreeByID(@PathVariable Integer moduleDegreeID) {
        modulesDegreeRepository.deleteByModuleDegreeID(moduleDegreeID);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/modulesdegree/byDegree/{degreeID}")
    public ResponseEntity<Void> deleteModuleDegreeByDegreeID(@PathVariable Integer degreeID) {
        modulesDegreeRepository.deleteByDegreeID(degreeID);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/modulesdegree/byModule/{moduleID}")
    public ResponseEntity<Void> deleteModuleDegreeByModuleID(@PathVariable Integer moduleID) {
        modulesDegreeRepository.deleteByModuleID(moduleID);
        return ResponseEntity.ok().build();
    }


    @Autowired
    private EntryRequirementRepository entryRequirementRepository;

    @PostMapping("/add/entryrequirement")
    public ResponseEntity<EntryRequirement> addEntryRequirement(@RequestBody EntryRequirement entryRequirement) {
        entryRequirementRepository.save(entryRequirement);
        return ResponseEntity.ok(entryRequirement);
    }

    @GetMapping("/get/entryrequirement/{requirementID}")
    public ResponseEntity<EntryRequirement> getEntryRequirementByID(@PathVariable Integer requirementID) {
        EntryRequirement entryRequirement = entryRequirementRepository.findByRequirementID(requirementID);
        return entryRequirement != null ? ResponseEntity.ok(entryRequirement) : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/entryrequirement/byDegree/{degreeId}")
    public ResponseEntity<List<EntryRequirement>> getEntryRequirementByDegreeID(@PathVariable Integer degreeId) {
        List<EntryRequirement> entryRequirements = entryRequirementRepository.findByDegreeID(degreeId);
        return entryRequirements.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(entryRequirements);
    }

    @GetMapping("/get/entryrequirement/byAlevel/{alevelID}")
    public ResponseEntity<List<EntryRequirement>> getEntryRequirementByALevelID(@PathVariable Integer alevelID) {
        List<EntryRequirement> entryRequirements = entryRequirementRepository.findByALevelID(alevelID);
        return entryRequirements.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(entryRequirements);
    }

    @GetMapping("/get/entryrequirement/byBtec/{btecID}")
    public ResponseEntity<List<EntryRequirement>> getEntryRequirementByBtecID(@PathVariable Integer btecID) {
        List<EntryRequirement> entryRequirements = entryRequirementRepository.findByBtecID(btecID);
        return entryRequirements.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(entryRequirements);
    }

    @GetMapping("/get/entryrequirement/byOcr/{ocrCaID}")
    public ResponseEntity<List<EntryRequirement>> getEntryRequirementByOcrCaID(@PathVariable Integer ocrCaID) {
        List<EntryRequirement> entryRequirements = entryRequirementRepository.findByOCRcaID(ocrCaID);
        return entryRequirements.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(entryRequirements);
    }

    @GetMapping("/get/entryrequirement/byHeDiploma/{heID}")
    public ResponseEntity<List<EntryRequirement>> getEntryRequirementByHeDiplomaID(@PathVariable Integer heID) {
        List<EntryRequirement> entryRequirements = entryRequirementRepository.findByHeID(heID);
        return entryRequirements.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(entryRequirements);
    }


    @DeleteMapping("/delete/entryrequirement/{requirementID}")
    public ResponseEntity<Void> deleteEntryRequirementByID(@PathVariable Integer requirementID) {
        entryRequirementRepository.deleteByRequirementID(requirementID);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/entryrequirement/byDegree/{degreeID}")
    public ResponseEntity<Void> deleteEntryRequirementByDegreeID(@PathVariable Integer degreeID) {
        entryRequirementRepository.deleteByDegreeID(degreeID);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/entryrequirement/byAlevel/{alevelID}")
    public ResponseEntity<Void> deleteEntryRequirementByALevelID(@PathVariable Integer alevelID) {
        entryRequirementRepository.deleteByDegreeID(alevelID);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/entryrequirement/byBtec/{btecID}")
    public ResponseEntity<Void> deleteEntryRequirementByBtecID(@PathVariable Integer btecID) {
        entryRequirementRepository.deleteByDegreeID(btecID);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/entryrequirement/byOcr/{ocrCaID}")
    public ResponseEntity<Void> deleteEntryRequirementByOcrCaID(@PathVariable Integer ocrCaID) {
        entryRequirementRepository.deleteByDegreeID(ocrCaID);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/entryrequirement/byHeDiploma/{heID}")
    public ResponseEntity<Void> deleteEntryRequirementByHeDiplomaID(@PathVariable Integer heID) {
        entryRequirementRepository.deleteByDegreeID(heID);
        return ResponseEntity.ok().build();
    }
}
