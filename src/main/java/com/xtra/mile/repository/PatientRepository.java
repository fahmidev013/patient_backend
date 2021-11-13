package com.xtra.mile.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xtra.mile.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}