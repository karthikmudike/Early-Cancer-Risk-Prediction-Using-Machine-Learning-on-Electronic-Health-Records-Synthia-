package com.karthikyadavmudike.learn_spring_boot.PatientRecord;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController
public class PatientRecordController {
	
	@Autowired
	private PatientRecordService record;
	
	
	@GetMapping("/PatientList")
	public List<PatientRecord> getAllRecords(){
		return this.record.getAllRecord();
		}
	
	@GetMapping("/PatientList/{id}")
	public  Optional<PatientRecord> getRecord(@PathVariable Long id){
			return this.record.getRecord(id);
		}

}
