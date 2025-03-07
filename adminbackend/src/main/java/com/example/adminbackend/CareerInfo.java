package com.example.adminbackend;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "careerinfo")
public class CareerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CareerID")
	private Integer careerId;

	@Column(name = "career_name", nullable = false, length = 255)
	private String careerName;

	@Column(name = "starting_salary")
	private Integer startingSalary;

	@Column(name = "average_salary")
	private Integer averageSalary;

	public CareerInfo() {}

	public CareerInfo(Integer careerId, String careerName, Integer startingSalary, Integer averageSalary) {
		this.careerId = careerId;
		this.careerName = careerName;
		this.startingSalary = startingSalary;
		this.averageSalary = averageSalary;
	}

	public Integer getCareerId() {return  careerId;}
	public void setCareerId(Integer careerId) {this.careerId = careerId;}

	public String getCareerName() {return  careerName;}
	public void setCareerName(String careerName) {this.careerName = careerName;}

	public Integer getStartingSalary() {return  startingSalary;}
	public void setStartingSalary(Integer startingSalary) {this.startingSalary = startingSalary;}

	public Integer getAverageSalary() {return  averageSalary;}
	public void setAverageSalary(Integer averageSalary) {this.averageSalary = averageSalary;}

}
