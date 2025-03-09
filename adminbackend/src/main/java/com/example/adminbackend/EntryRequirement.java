package com.example.adminbackend;

import jakarta.persistence.*;
import org.springframework.web.servlet.view.AbstractTemplateView;

@Entity
@Table(name = "entryrequirement")
public class EntryRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "requiredID")
    private Integer requirementID;

    @Column(name = "ucas_points")
    private Integer ucasPoints;

    @ManyToOne
    @JoinColumn(name = "degree_erid", referencedColumnName = "DegreeID", nullable = false)
    private Degree degreeER;

    @ManyToOne
    @JoinColumn(name = "alevel_erid", referencedColumnName = "ALevelID")
    private ALevel aLevel;

    @ManyToOne
    @JoinColumn(name = "btec_erid", referencedColumnName = "BTECID")
    private Btec btec;

    @ManyToOne
    @JoinColumn(name = "ocr_erid", referencedColumnName = "OCRCaID")
    private Ocr ocr;

    @ManyToOne
    @JoinColumn(name = "he_erid", referencedColumnName = "HEID")
    private HEDiploma heD;

    public EntryRequirement() {}

    public EntryRequirement(Integer requirementID, Integer ucasPoints, Degree degree, ALevel aLevel, Btec btec, Ocr ocr, HEDiploma heD) {
        this.requirementID = requirementID;
        this.ucasPoints = ucasPoints;
        this.degreeER = degree;
        this.aLevel = aLevel;
        this.btec = btec;
        this.ocr = ocr;
        this.heD = heD;
    }

    public Integer getRequirementID() {return requirementID;}
    public void setRequirementID(Integer requirementID) {this.requirementID = requirementID;}

    public Integer getUcasPoints() {return ucasPoints;}
    public void setUCasPoints(Integer ucasPoints) {this.ucasPoints = ucasPoints;}

    public Degree getDegreeER() {return degreeER;}
    public void setDegreeER(Degree degreeER) {this.degreeER = degreeER;}

    public ALevel getALevel() {return aLevel;}
    public void setALevel(ALevel aLevel) {this.aLevel = aLevel;}

    public Btec getBtec() {return btec;}
    public void setBtec(Btec btec) {this.btec = btec;}

    public Ocr getOcr() {return ocr;}
    public void setOcr(Ocr ocr) {this.ocr = ocr;}

    public HEDiploma getHeD() {return heD;}
    public void setHeD(HEDiploma heD) {this.heD = heD;}

}
