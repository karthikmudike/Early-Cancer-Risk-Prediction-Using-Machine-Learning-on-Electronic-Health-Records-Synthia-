package com.karthikyadavmudike.learn_spring_boot.Doctors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface DoctorsRepository extends JpaRepository<Doctors, Long> {
	
	
}
