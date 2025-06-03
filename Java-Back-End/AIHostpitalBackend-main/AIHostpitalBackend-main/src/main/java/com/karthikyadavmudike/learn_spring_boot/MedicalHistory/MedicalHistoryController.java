package com.karthikyadavmudike.learn_spring_boot.MedicalHistory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MedicalHistoryController {
	
	@Autowired
	private MedicalHistoryRepository repo;
	
	@Autowired
	private MedicalHistoryService list;
	
	@GetMapping("/MedicalHistory/{Id}")
	List<String> getHistory(@PathVariable Long Id)
	{
		return list.findAllByPatientId(Id);
	}

}
