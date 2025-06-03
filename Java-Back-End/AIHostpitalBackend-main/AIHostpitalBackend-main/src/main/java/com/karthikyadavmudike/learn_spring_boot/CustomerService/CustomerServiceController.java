package com.karthikyadavmudike.learn_spring_boot.CustomerService;

import java.util.List;

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

import com.karthikyadavmudike.learn_spring_boot.Appointments.Appointment;

@CrossOrigin
@RestController
public class CustomerServiceController {
	
	private int count = 1;
	
	@Autowired
	private CustomerServiceRepository repo;
	
	@PostMapping("/CustomerService/")
	public ResponseEntity<CustomerService> updateDetails(@RequestBody CustomerService customer)
	{	
		customer.setCustomerId(this.count++);
		this.repo.save(customer);
		return new ResponseEntity<CustomerService>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerService/")
	public List<CustomerService> GetDetails()
	{
		return repo.findAll();
	}

	@DeleteMapping("/DeleteList/{Id}")
	public ResponseEntity<Void> deleteTheRecord(@PathVariable long Id)
	{
		
		repo.deleteById(Id);
		
		return ResponseEntity.notFound().build();	
	}
}
