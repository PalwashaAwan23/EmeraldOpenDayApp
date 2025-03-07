package com.example.adminbackend;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerInfoRepository extends JpaRepository<CareerInfo, Integer> {

    @Query("SELECT c FROM CareerInfo c WHERE c.careerName = :careerName")
    CareerInfo findByCareerName(@Param("careerName") String careerName);

    @Query("SELECT c FROM CareerInfo c WHERE c.careerId = :careerId")
    CareerInfo findByCareerId(@Param("careerId") Integer careerId);

    @Modifying
    @Transactional
    @Query("DELETE FROM CareerInfo c WHERE c.careerName = :CareerName")
    void removeCareerByCareerName(@Param("CareerName") String CareerName);

    @Modifying
    @Transactional
    @Query("DELETE FROM CareerInfo c WHERE c.careerId = :CareerID")
    void removeCareerByCareerId(@Param("CareerID") Integer CareerID);

}

