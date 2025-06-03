package com.karthikyadavmudike.learn_spring_boot.PatientRecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface PatientRecordRepository extends JpaRepository<PatientRecord, Long> {

}
