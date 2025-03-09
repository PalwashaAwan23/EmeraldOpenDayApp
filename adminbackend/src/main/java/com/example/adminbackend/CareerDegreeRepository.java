package com.example.adminbackend;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CareerDegreeRepository extends JpaRepository<CareerDegree, Integer> {

    @Query("SELECT e FROM CareerDegree e WHERE e.careerDegreeID = :careerDegreeID")
    CareerDegree findByCareerDegreeID(@Param("careerDegreeID") Integer careerDegreeID);

    @EntityGraph(attributePaths = {"degreeCDId", "careerInfoCDId"})
    @Query("SELECT e FROM CareerDegree e WHERE e.degreeCDId.degreeId = :degreeID")
    List<CareerDegree> findByDegreeID(@Param("degreeID") Integer degreeID);

    @EntityGraph(attributePaths = {"degreeCDId","careerInfoCDId"})
    @Query("SELECT e FROM CareerDegree e WHERE e.careerInfoCDId.careerId = :careerID")
    List<CareerDegree> findByCareerID(@Param("careerID") Integer careerID);

    @Modifying
    @Transactional
    @Query("DELETE FROM CareerDegree e WHERE e.careerDegreeID = :careerDegreeID")
    void deleteByCareerDegreeID(@Param("careerDegreeID") Integer careerDegreeID);

    @Modifying
    @Transactional
    @Query("DELETE FROM CareerDegree e WHERE e.degreeCDId.degreeId = :degreeID")
    void deleteByDegreeID(@Param("degreeID") Integer degreeID);

    @Modifying
    @Transactional
    @Query("DELETE FROM CareerDegree e WHERE e.careerInfoCDId.careerId = :careerID")
    void deleteByCareerID(@Param("careerID") Integer careerID);
}
