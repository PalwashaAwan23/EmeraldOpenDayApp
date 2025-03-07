package com.example.adminbackend;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OcrRepository extends JpaRepository<Ocr, Integer> {

    @Query("SELECT c FROM Ocr c WHERE c.minGrade = :minGrade")
    Ocr findOCRByMinGrade(@Param("minGrade") String minGrade);

    @Query("SELECT c FROM Ocr c WHERE c.maxGrade = :maxGrade")
    Ocr findOCRByMaxGrade(@Param("maxGrade") String maxGrade);

    @Query("SELECT c FROM Ocr c WHERE c.ocrCaID = :ocrCaID")
    Ocr findByOCRId(@Param("ocrCaID") Integer ocrCaID);


    @Modifying
    @Transactional
    @Query("DELETE FROM Ocr c WHERE c.minGrade = :MinGrade")
    void removeOCRByMinGrade(@Param("MinGrade") String MinGrade);

    @Modifying
    @Transactional
    @Query("DELETE FROM Ocr c WHERE c.maxGrade = :MaxGrade")
    void removeOCRByMaxGrade(@Param("MaxGrade") String MaxGrade);

    @Modifying
    @Transactional
    @Query("DELETE FROM Ocr c WHERE c.ocrCaID = :OcrCaID")
    void removeOCRByOCRID(@Param("OcrCaID") Integer OcrCaID);

}
