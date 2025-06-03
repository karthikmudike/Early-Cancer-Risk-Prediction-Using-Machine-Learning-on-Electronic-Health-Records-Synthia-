package com.karthikyadavmudike.learn_spring_boot.Doctors;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class DoctorsController {
	
	@Autowired
	private DoctorsRepository repo;
	
	@Autowired
	private DoctorsService service;
	
	@GetMapping("/DoctorsList/{Id}")
	Optional<Doctors> getDoctor(@PathVariable long Id)
	{
		return this.repo.findById(Id);
	}
	
	@GetMapping("/DoctorsListAll")
	List<Doctors> getAllDoctor()
	{
		return this.repo.findAll();
	}
	
	@GetMapping("/DoctorRecordByName/{name}")
	List<Doctors> getDoctorsByName(@PathVariable String name)
	{
		return this.service.getDoctorReportByName(name);
	}
}
