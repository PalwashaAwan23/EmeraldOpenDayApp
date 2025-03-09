package com.example.adminbackend;

import org.hibernate.engine.spi.ManagedEntity;
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
	CommandLineRunner run(DegreeRepository degreeRepository, AdminController controller,
						  EntryRequirementRepository entryRequirementRepository, ALevelRepository aLevelRepository,
						  BtecRepository btecRepository, OcrRepository ocrRepository, HEDiplomaRepository heDiplomaRepository) {
		return args -> {

//			ResponseEntity<Degree> degreeResponse = controller.getDegreeById(6);
//			Degree degree = degreeResponse.getBody();
//
//			ResponseEntity<ALevel> aLevelResponseEntity = controller.getAlevelById(1);
//			ALevel aLevel = aLevelResponseEntity.getBody();
//
//			ResponseEntity<Ocr> ocrResponseEntity = controller.getOCRById(1);
//			Ocr ocr = ocrResponseEntity.getBody();
//
//			ResponseEntity<Btec> btecResponseEntity = controller.getBTECById(1);
//			Btec btec = btecResponseEntity.getBody();
//
//			ResponseEntity<HEDiploma> heDiplomaResponseEntity = controller.getHEById(1);
//			HEDiploma hediploma = heDiplomaResponseEntity.getBody();
//
//			System.out.println(hediploma.getHeID());
//
//			System.out.println(degree.getDegreeName());
//			if (degree == null || aLevel == null || ocr == null  || btec == null || hediploma == null ) {
//				System.err.println("Error: Degree or Module with ID 1 not found.");
//				return;
//			}
//
//			EntryRequirement entryRequirement= new EntryRequirement(null, 120,  degree, aLevel, btec, ocr, hediploma);
//			entryRequirementRepository.save(entryRequirement);
//			System.out.println("Entry Requirement saved.");

			EntryRequirement entryRequirement = entryRequirementRepository.findByRequirementID(1);
			System.out.println("Requirement ID is " + entryRequirement.getRequirementID());
			System.out.println("Degree Name is " + entryRequirement.getDegreeER().getDegreeName());
			System.out.println("ALevel is " + entryRequirement.getALevel().getAlevelID());
			System.out.println("BTEC is " + entryRequirement.getBtec().getBtecID());
			System.out.println("OCR is " + entryRequirement.getOcr().getOcrCaID());
			System.out.println("HE is " + entryRequirement.getHeD().getHeID());


//			Integer moduleDegreeID = 1;
//
//
//			ResponseEntity<ModulesDegree> response = controller.getModulesDegreeByID(1);
//
//
//			ModulesDegree modulesDegree = response.getBody();
//
//			if (modulesDegree != null) {
//				System.out.println("CareerDegree found with ID: " + modulesDegree.getModuleDegreeID());
//				System.out.println("Degree ID: " + modulesDegree.getDegreeMDId().getDegreeName());
//				System.out.println("Career ID: " + modulesDegree.getModuleMDId().getModuleName());
//			} else {
//				System.out.println("CareerDegree not found with ID: " + moduleDegreeID);
//			}



		};
	}

}
