package com.example.prescriptionApp.repository;

import com.example.prescriptionApp.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    @Query("SELECT p FROM Prescription p WHERE p.prescriptionDate BETWEEN :start AND :end ORDER BY p.prescriptionDate ASC")
    List<Prescription> findbyDataRange(@Param("start") LocalDate start, @Param("end") LocalDate end);

    @Query("SELECT p.prescriptionDate AS date, COUNT(p) AS count " +
            "FROM Prescription p " +
            "WHERE p.prescriptionDate BETWEEN :start AND :end " +
            "GROUP BY p.prescriptionDate " +
            "ORDER BY p.prescriptionDate ASC")
    List<Object[]> countByDateRange(@Param("start") LocalDate start,
                                    @Param("end") LocalDate end);
}
