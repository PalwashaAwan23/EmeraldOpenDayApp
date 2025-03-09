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
public interface EntryRequirementRepository extends JpaRepository<EntryRequirement, Integer> {

    @Query("SELECT e FROM EntryRequirement e WHERE e.requirementID = :requirementID")
    EntryRequirement findByRequirementID(@Param("requirementID") Integer requirementID);

    @EntityGraph(attributePaths = {"degreeER", "aLevel", "btec", "ocr", "heD"})
    @Query("SELECT e FROM EntryRequirement e WHERE e.degreeER.degreeId = :degreeID")
    List<EntryRequirement> findByDegreeID(@Param("degreeID") Integer degreeID);

    @EntityGraph(attributePaths = {"degreeER", "aLevel", "btec", "ocr", "heD"})
    @Query("SELECT e FROM EntryRequirement e WHERE e.aLevel.alevelID = :aLevelID")
    List<EntryRequirement> findByALevelID(@Param("aLevelID") Integer aLevelID);

    @EntityGraph(attributePaths = {"degreeER", "aLevel", "btec", "ocr", "heD"})
    @Query("SELECT e FROM EntryRequirement e WHERE e.btec.btecID = :btecID")
    List<EntryRequirement> findByBtecID(@Param("btecID") Integer btecID);

    @EntityGraph(attributePaths = {"degreeER", "aLevel", "btec", "ocr", "heD"})
    @Query("SELECT e FROM EntryRequirement e WHERE e.ocr.ocrCaID = :ocrCaID")
    List<EntryRequirement> findByOCRcaID(@Param("ocrCaID") Integer ocrCaID);

    @EntityGraph(attributePaths = {"degreeER", "aLevel", "btec", "ocr", "heD"})
    @Query("SELECT e FROM EntryRequirement e WHERE e.heD.heID = :heID")
    List<EntryRequirement> findByHeID(@Param("heID") Integer heID);


    @Modifying
    @Transactional
    @Query("DELETE FROM EntryRequirement e WHERE e.requirementID = :requirementID")
    void deleteByRequirementID(@Param("requirementID") Integer requirementID);

    @Modifying
    @Transactional
    @Query("DELETE FROM EntryRequirement e WHERE e.degreeER.degreeId = :degreeID")
    void deleteByDegreeID(@Param("degreeID") Integer degreeID);

    @Modifying
    @Transactional
    @Query("DELETE FROM EntryRequirement e WHERE e.aLevel.alevelID = :aLevelID")
    void deleteByALevelID(@Param("aLevelID") Integer aLevelID);

    @Modifying
    @Transactional
    @Query("DELETE FROM EntryRequirement e WHERE e.btec.btecID = :btecID")
    void deleteByBtecID(@Param("btecID") Integer btecID);

    @Modifying
    @Transactional
    @Query("DELETE FROM EntryRequirement e WHERE e.ocr.ocrCaID = :ocrCaID")
    void deleteByOcrID(@Param("ocrCaID") Integer ocrCaID);

    @Modifying
    @Transactional
    @Query("DELETE FROM EntryRequirement e WHERE e.heD.heID = :heID")
    void deleteByHeID(@Param("heID") Integer heID);
}
