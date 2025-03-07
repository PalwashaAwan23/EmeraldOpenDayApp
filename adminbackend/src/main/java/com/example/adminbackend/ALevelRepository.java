package com.example.adminbackend;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ALevelRepository extends JpaRepository<ALevel, Integer> {

    @Query("SELECT c FROM ALevel c WHERE c.minGrade = :minGrade")
    ALevel findByAlevelMinGrade(@Param("minGrade") String minGrade);

    @Query("SELECT c FROM ALevel c WHERE c.maxGrade = :maxGrade")
    ALevel findByAlevelMaxGrade(@Param("maxGrade") String maxGrade);

    @Query("SELECT c FROM ALevel c WHERE c.alevelID = :alevelId")
    ALevel findByAlevelId(@Param("alevelId") Integer alevelId);


    @Modifying
    @Transactional
    @Query("DELETE FROM ALevel c WHERE c.minGrade = :MinGrade")
    void removeAlevelByMinGrade(@Param("MinGrade") String MinGrade);

    @Modifying
    @Transactional
    @Query("DELETE FROM ALevel c WHERE c.maxGrade = :MaxGrade")
    void removeAlevelByMaxGrade(@Param("MaxGrade") String MaxGrade);

    @Modifying
    @Transactional
    @Query("DELETE FROM ALevel c WHERE c.alevelID = :ALevelID")
    void removeALevelByAlevelID(@Param("ALevelID") Integer ALevelID);

}
