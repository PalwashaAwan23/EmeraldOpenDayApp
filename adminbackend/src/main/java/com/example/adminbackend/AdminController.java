package com.example.adminbackend;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/get/ocr/id/{btecId}")
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

    @DeleteMapping("/remove/ocr/id/{btecId}")
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

    @GetMapping("/get/he/id/{btecId}")
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

    @DeleteMapping("/remove/he/id/{btecId}")
    public ResponseEntity<Void> removHEById(@PathVariable Integer heID) {
        hediplomaRepository.removeHEByHEID(heID);
        return ResponseEntity.ok().build();
    }

}
