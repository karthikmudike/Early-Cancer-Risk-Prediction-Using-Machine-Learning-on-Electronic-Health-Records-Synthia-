package com.karthikyadavmudike.learn_spring_boot.PatientRecord;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientRecordService {
	
	@Autowired
	private PatientRecordRepository recordRepo;

	
	List<PatientRecord> getAllRecord()
	{
		return this.recordRepo.findAll();
	}
	
	Optional<PatientRecord> getRecord(Long id)
	{
		return this.recordRepo.findById(id);
	}
	

}
