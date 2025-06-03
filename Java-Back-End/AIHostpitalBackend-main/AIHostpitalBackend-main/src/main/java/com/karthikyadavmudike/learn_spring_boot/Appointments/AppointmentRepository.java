package com.karthikyadavmudike.learn_spring_boot.Appointments;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	
}
