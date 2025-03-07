package com.example.adminbackend;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface HEDiplomaRepository extends JpaRepository<HEDiploma, Integer> {

    @Query("SELECT c FROM HEDiploma c WHERE c.minGrade = :minGrade")
    HEDiploma findByHEMinGrade(@Param("minGrade") String minGrade);

    @Query("SELECT c FROM HEDiploma c WHERE c.maxGrade = :maxGrade")
    HEDiploma findByHEMaxGrade(@Param("maxGrade") String maxGrade);

    @Query("SELECT c FROM HEDiploma c WHERE c.heID = :heID")
    HEDiploma findByHEID(@Param("heId") Integer heId);


    @Modifying
    @Transactional
    @Query("DELETE FROM HEDiploma c WHERE c.minGrade = :MinGrade")
    void removeHEByMinGrade(@Param("MinGrade") String MinGrade);

    @Modifying
    @Transactional
    @Query("DELETE FROM HEDiploma c WHERE c.maxGrade = :MaxGrade")
    void removeHEByMaxGrade(@Param("MaxGrade") String MaxGrade);

    @Modifying
    @Transactional
    @Query("DELETE FROM HEDiploma c WHERE c.heID = :HEID")
    void removeHEByHEID(@Param("HEID") Integer HEID);
}
