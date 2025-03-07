package com.example.adminbackend;

import jakarta.persistence.*;


@Entity
@Table(name = "careerdegree")
public class CareerDegree {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CareerDegreeID", nullable = false)
	private Integer careerDegreeID;

	@ManyToOne
	@JoinColumn(name = "degree_degID", referencedColumnName = "DegreeID", nullable = false)
	private Degree degreeCDId;

	@ManyToOne
	@JoinColumn(name = "careerinfo_careerid", referencedColumnName = "CareerID", nullable = false)
	private CareerInfo careerInfoCDId;

	public CareerDegree() {}

	public CareerDegree(Integer careerDegreeID, Degree degreeCDId, CareerInfo careerInfoCDId) {
		this.careerDegreeID = careerDegreeID;
		this.degreeCDId = degreeCDId;
		this.careerInfoCDId = careerInfoCDId;
	}

	public Integer getCareerDegreeID() { return careerDegreeID; }
	public void setCareerDegreeID(Integer careerDegreeID) { this.careerDegreeID = careerDegreeID; }

	public Degree getDegreeCDId() { return degreeCDId; }
	public void setDegreeCDId(Degree degreeCDId) { this.degreeCDId = degreeCDId; }

	public CareerInfo getCareerInfoCDId() { return careerInfoCDId; }
	public void setCareerInfoCDId(CareerInfo careerInfoCDId) { this.careerInfoCDId = careerInfoCDId; }
}



