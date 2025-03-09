package com.example.adminbackend;

import jakarta.persistence.*;

@Entity
@Table(name = "modulesdegree")
public class ModulesDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ModulesDegreeID")
    private Integer moduleDegreeID;

    @ManyToOne
    @JoinColumn(name = "deg_degreeid", referencedColumnName = "DegreeID", nullable = false)
    private Degree degreeMDId;

    @ManyToOne
    @JoinColumn(name = "modules_moduleid", referencedColumnName = "ModuleID", nullable = false)
    private Modules moduleMDId;

    public ModulesDegree() {}

    public ModulesDegree(Integer moduleDegreeID, Degree degreeMDId, Modules moduleMDId) {this.moduleDegreeID = moduleDegreeID; this.degreeMDId = degreeMDId; this.moduleMDId = moduleMDId;}

    public Integer getModuleDegreeID() {return moduleDegreeID;}
    public void setModuleDegreeID(Integer moduleDegreeID) {this.moduleDegreeID = moduleDegreeID;}

    public Degree getDegreeMDId() {return degreeMDId;}
    public void setDegreeMDId(Degree degreeMDId) {this.degreeMDId = degreeMDId;}

    public Modules getModuleMDId() {return moduleMDId;}
    public void setModuleMDId(Modules moduleMDId) {this.moduleMDId = moduleMDId;}
}
