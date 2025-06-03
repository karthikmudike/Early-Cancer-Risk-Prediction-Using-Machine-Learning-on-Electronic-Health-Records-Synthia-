package com.karthikyadavmudike.learn_spring_boot.BillPayment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BillPaymentController {
	
	@Autowired
	private BillPaymentService service;
	
	@Autowired
	private BillPaymentRepository repo;
	
	@GetMapping("/BillPaymentOfPatient/{Id}")
	List<BillPayment> getAllPatientBills(@PathVariable Long Id)
	{
		return this.service.getAllBillsById(Id);
	}
	
	@DeleteMapping("/DeleteTheRecord/{Id}")
	ResponseEntity<Void> deleteTheRecord(@PathVariable long Id)
	{
		if(this.service.getAllBillsById(Id)!=null)
		{
			this.service.deleteTheList(Id);
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();	
	}
}
