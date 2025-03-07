package com.example.adminbackend;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "modules")
public class Modules {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ModuleID")
	private Integer moduleId;

	@Column(name = "module_name", length = 255, nullable = false)
	private String moduleName;

	@Column(name = "credits", nullable = false, length = 50)
	private Integer credits;

	public Modules() {}

	public Modules(Integer moduleId, String moduleName, Integer credits) {
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.credits = credits;
	}

	public Integer getModuleId() {return moduleId;}
	public void setModuleId(Integer moduleId) {this.moduleId = moduleId;}

	public String getModuleName() {return moduleName;}
	public void setModuleName(String moduleName) {this.moduleName = moduleName;}

	public Integer getCredits() {return credits;}
	public void setCredits(Integer credits) {this.credits = credits;}
}


