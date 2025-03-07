package com.example.adminbackend;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BtecRepository extends JpaRepository<Btec, Integer> {

    @Query("SELECT c FROM Btec c WHERE c.minGrade = :minGrade")
    Btec findByBTECMinGrade(@Param("minGrade") String minGrade);

    @Query("SELECT c FROM Btec c WHERE c.maxGrade = :maxGrade")
    Btec findByBTECMaxGrade(@Param("maxGrade") String maxGrade);

    @Query("SELECT c FROM Btec c WHERE c.btecID = :btecId")
    Btec findByBTECId(@Param("btecId") Integer btecId);


    @Modifying
    @Transactional
    @Query("DELETE FROM Btec c WHERE c.minGrade = :MinGrade")
    void removeBTECByMinGrade(@Param("MinGrade") String MinGrade);

    @Modifying
    @Transactional
    @Query("DELETE FROM Btec c WHERE c.maxGrade = :MaxGrade")
    void removeBTECByMaxGrade(@Param("MaxGrade") String MaxGrade);

    @Modifying
    @Transactional
    @Query("DELETE FROM Btec c WHERE c.btecID = :BtecID")
    void removeBTECByAlevelID(@Param("BtecID") Integer BtecID);
}
