package com.karthikyadavmudike.learn_spring_boot.Appointments;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AppointmentController {
	
	@Autowired
	private AppointmentRepository repo;
	
	@Autowired
	private AppointmentService service;
	
	@PostMapping("/AppointmentDetails/{Id}")
	public ResponseEntity<Appointment> UpdateDetails(@PathVariable long Id, @RequestBody Appointment appointmentBody)
	{
		repo.save(appointmentBody);
		
		return new ResponseEntity<Appointment>(appointmentBody, HttpStatus.OK);
	}
	
	@GetMapping("/AllAppointment/{Id}")
	public List<Appointment> getAllAppointmentDetailsById(@PathVariable long Id)
	{
		return this.service.getAllDataByAppointmentId(Id);
	}
	
	@GetMapping("/AllAppointment")
	public List<Appointment> getAllAppointmentDetails()
	{
		return this.repo.findAll();
	}
	
	@GetMapping("/AppointmentDetails/{Id}")
	public Optional<Appointment> getAllAppointmentDetailsByAppointmentId(@PathVariable long Id)
	{
		return this.repo.findById(Id);
	}
	
	@DeleteMapping("/DeleteTheReocrd/{Id}")
	public ResponseEntity<Void> DeleteTheRecord(@PathVariable long Id)
	{
		Optional<Appointment> list = this.repo.findById(Id);
		
		if(list!=null)
		{
			this.repo.deleteById(Id);
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();	
	}
	
	@PutMapping("/AppointmentUpdate/{Id}")
	public ResponseEntity<Void> UpdateAppointment(@PathVariable long Id, @RequestBody Appointment appointment)
	{
		
		if(Id!=0)
		{
			Optional<Appointment> list = this.repo.findById(Id);
			if(list != null)
			{
				this.repo.deleteById(Id);
				this.repo.save(appointment);
				return ResponseEntity.noContent().build();
			}else
			{
				appointment.setAppointmentId(this.repo.count()+1);
				this.repo.save(appointment);
				System.out.println(appointment);
				return ResponseEntity.notFound().build();
			}
		}else
		{
			appointment.setAppointmentId(this.repo.count()+1);
			this.repo.save(appointment);
			System.out.println(appointment);
			return ResponseEntity.notFound().build();
		}
		
		}
		
		
	}
