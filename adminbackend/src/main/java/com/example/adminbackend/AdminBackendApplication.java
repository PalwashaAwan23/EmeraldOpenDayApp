package com.example.adminbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.awt.dnd.DragGestureEvent;

@SpringBootApplication
public class AdminBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(DegreeRepository degreeRepository, AdminController controller, CareerInfoRepository careerInfoRepository,
						  CareerDegreeRepository careerDegreeRepository) {
		return args -> {
//
			Degree degree = degreeRepository.findById(1).orElse(null);
			CareerInfo career = careerInfoRepository.findById(1).orElse(null);

			if (degree == null || career == null) {
				System.out.println("Error: Degree or CareerInfo with ID 1 not found.");
				return;
			}

			// Save new CareerDegree entry
			CareerDegree careerDegree = new CareerDegree(null, degree, career);
			careerDegreeRepository.save(careerDegree);
			System.out.println("CareerDegree entry added with ID: " + careerDegree.getCareerDegreeID());


		};
	}

}
