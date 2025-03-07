package com.example.adminbackend;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Integer> {

    @Query("SELECT c FROM Degree c WHERE c.degreeName = :degreeName")
    Degree findByDegreeName(@Param("degreeName") String degreeName);

    @Query("SELECT c FROM Degree c WHERE c.degreeId = :degreeId")
    Degree findByDegreeId(@Param("degreeId") Integer degreeId);


    @Modifying
    @Transactional
    @Query("DELETE FROM Degree c WHERE c.degreeName = :DegreeName")
    void removeDegreeByDegreeName(@Param("DegreeName") String DegreeName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Degree c WHERE c.degreeId = :DegreeID")
    void removeDegreeByDegreeId(@Param("DegreeID") Integer DegreeID);
}

