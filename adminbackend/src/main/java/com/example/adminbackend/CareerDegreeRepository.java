package com.example.adminbackend;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CareerDegreeRepository extends JpaRepository<CareerDegree, Integer> {

    @Query("SELECT e FROM CareerDegree e WHERE e.careerDegreeID = :CareerDegreeID")
    CareerDegree findByCareerDegreeID(@Param("CareerDegreeID") Integer CareerDegreeID);


//    @Query("SELECT e FROM CareerDegree e WHERE e.degreeTBcareerId.degreeId = :degreeID")
//    List<CareerDegree> findByDegreeID(@Param("degreeID") Integer degreeID);
//
//
//    @Query("SELECT e FROM CareerDegree e WHERE e.careerInfocareerId.careerId = :careerID")
//    List<CareerDegree> findByCareerID(@Param("careerID") Integer careerID);
//
//
//    @Modifying
//    @Transactional
//    @Query("DELETE FROM CareerDegree e WHERE e.careerDegreeID = :CareerDegreeID")
//    void deleteByCareerDegreeID(@Param("CareerDegreeID") Integer CareerDegreeID);
//
//
//    @Modifying
//    @Transactional
//    @Query("DELETE FROM CareerDegree e WHERE e.degreeTBcareerId.degreeId = :degreeID")
//    void deleteByDegreeID(@Param("degreeID") Integer degreeID);
//
//
//    @Modifying
//    @Transactional
//    @Query("DELETE FROM CareerDegree e WHERE e.careerInfocareerId.careerId = :careerID")
//    void deleteByCareerID(@Param("careerID") Integer careerID);
}
