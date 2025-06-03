package com.karthikyadavmudike.learn_spring_boot.MedicalHistory;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MedicalHistory {
	
	public MedicalHistory() {}
	
	@Id
	private long RecordId;
	
	private long PatientId;
	
	private String Record;
	

	public long getRecordId() {
		return RecordId;
	}

	public void setRecordId(long recordId) {
		RecordId = recordId;
	}

	public long getPatientId() {
		return PatientId;
	}

	public void setPatientId(long patientId) {
		PatientId = patientId;
	}

	public String getRecord() {
		return Record;
	}

	public void setRecord(String record) {
		Record = record;
	}
	
	
	
}
