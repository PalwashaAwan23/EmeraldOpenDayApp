package com.example.adminbackend;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModulesDegreeRepository extends JpaRepository<ModulesDegree, Integer> {

    @Query("SELECT e FROM ModulesDegree e WHERE e.moduleDegreeID = :moduleDegreeID")
    ModulesDegree findByModuleDegreeID(@Param("moduleDegreeID") Integer moduleDegreeID);

    @EntityGraph(attributePaths = {"degreeCDId", "careerInfoCDId"})
    @Query("SELECT e FROM ModulesDegree e WHERE e.degreeMDId.degreeId = :degreeID")
    List<ModulesDegree> findByDegreeID(@Param("degreeID") Integer degreeID);

    @EntityGraph(attributePaths = {"degreeCDId","careerInfoCDId"})
    @Query("SELECT e FROM ModulesDegree e WHERE e.moduleMDId.moduleId = :moduleId")
    List<ModulesDegree> findByModuleID(@Param("moduleId") Integer moduleId);

    @Modifying
    @Transactional
    @Query("DELETE FROM ModulesDegree e WHERE e.moduleDegreeID = :moduleDegreeID")
    void deleteByModuleDegreeID(@Param("moduleDegreeID") Integer moduleDegreeID);

    @Modifying
    @Transactional
    @Query("DELETE FROM ModulesDegree e WHERE e.degreeMDId.degreeId = :degreeID")
    void deleteByDegreeID(@Param("degreeID") Integer degreeID);

    @Modifying
    @Transactional
    @Query("DELETE FROM ModulesDegree e WHERE e.moduleMDId.moduleId = :moduleId")
    void deleteByModuleID(@Param("moduleId") Integer moduleId);

}
