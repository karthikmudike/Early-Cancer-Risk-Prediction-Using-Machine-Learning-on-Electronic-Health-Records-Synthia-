package com.karthikyadavmudike.learn_spring_boot.MedicalHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {

}
