package com.example.adminbackend;


import jakarta.persistence.*;


@Entity
@Table(name = "degree")
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DegreeID")
    private Integer degreeId;

    @Column(name = "degree_name", nullable = false, length = 500)
    private String degreeName;

    @Column(name = "UCASCode", length = 50)
    private String ucasCode;

    @Column(name = "course_length", length = 50)
    private String courseLength;

    public Degree() {}

    public Degree(Integer degreeId, String degreeName, String ucasCode, String courseLength) {
        this.degreeId = degreeId;
        this.degreeName = degreeName;
        this.courseLength = courseLength;
        this.ucasCode = ucasCode;
    }

    public Integer getDegreeId() { return degreeId; }
    public void setDegreeId(Integer degreeId) { this.degreeId = degreeId; }

    public String getDegreeName() { return degreeName; }
    public void setDegreeName(String degreeName) { this.degreeName = degreeName; }

    public String getUcasCode() { return ucasCode; }
    public void setUcasCode(String ucasCode) { this.ucasCode = ucasCode; }

    public String getCourseLength() { return courseLength; }
    public void setCourseLength(String courseLength) { this.courseLength = courseLength; }
}
