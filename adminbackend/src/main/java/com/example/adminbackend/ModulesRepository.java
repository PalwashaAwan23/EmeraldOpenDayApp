package com.example.adminbackend;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ModulesRepository extends JpaRepository<Modules, Integer> {

    @Query("SELECT c FROM Modules c WHERE c.moduleName = :moduleName")
    Modules findByModuleName(@Param("moduleName") String moduleName);

    @Query("SELECT c FROM Modules c WHERE c.moduleId = :degreeId")
    Modules findByModuleId(@Param("degreeId") Integer degreeId);


    @Modifying
    @Transactional
    @Query("DELETE FROM Modules c WHERE c.moduleName = :ModuleName")
    void removeModuleByModuleName(@Param("ModuleName") String ModuleName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Modules c WHERE c.moduleId = :ModuleID")
    void removeModuleByModuleId(@Param("ModuleID") Integer ModuleID);
}
