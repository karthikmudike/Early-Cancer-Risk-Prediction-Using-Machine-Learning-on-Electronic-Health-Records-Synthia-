package com.karthikyadavmudike.learn_spring_boot.PatientRecord;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PatientRecord {
	
	@Id
	private long PatientId;
	private String PatientName;
	private int PatientAge;
	private String PatientGender;
	private String PatientAddress;
	private String PatientCity;
	private long PatientZipCode;
	private Date PatientDOB;
	private String PatientPhoneNumber;
	private String PatientEmail;
	private String isBeenHere;
	
	public PatientRecord() {}
	
	public PatientRecord(long patientId, String patientName, int patientAge, String patientGender,
			String patientAddress, String patientCity, long patientZipCode, Date patientDOB, String patientPhoneNumber,
			String patientEmail, String isBeenHere) {
		super();
		PatientId = patientId;
		PatientName = patientName;
		PatientAge = patientAge;
		PatientGender = patientGender;
		PatientAddress = patientAddress;
		PatientCity = patientCity;
		PatientZipCode = patientZipCode;
		PatientDOB = patientDOB;
		PatientPhoneNumber = patientPhoneNumber;
		PatientEmail = patientEmail;
		this.isBeenHere = isBeenHere;
	}
	public long getPatientId() {
		return PatientId;
	}
	public void setPatientId(long patientId) {
		PatientId = patientId;
	}
	public String getPatientName() {
		return PatientName;
	}
	public void setPatientName(String patientName) {
		PatientName = patientName;
	}
	public int getPatientAge() {
		return PatientAge;
	}
	public void setPatientAge(int patientAge) {
		PatientAge = patientAge;
	}
	public String getPatientGender() {
		return PatientGender;
	}
	public void setPatientGender(String patientGender) {
		PatientGender = patientGender;
	}
	public String getPatientAddress() {
		return PatientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		PatientAddress = patientAddress;
	}
	public String getPatientCity() {
		return PatientCity;
	}
	public void setPatientCity(String patientCity) {
		PatientCity = patientCity;
	}
	public long getPatientZipCode() {
		return PatientZipCode;
	}
	public void setPatientZipCode(long patientZipCode) {
		PatientZipCode = patientZipCode;
	}
	public Date getPatientDOB() {
		return PatientDOB;
	}
	public void setPatientDOB(Date patientDOB) {
		PatientDOB = patientDOB;
	}
	public String getPatientPhoneNumber() {
		return PatientPhoneNumber;
	}
	public void setPatientPhoneNumber(String patientPhoneNumber) {
		PatientPhoneNumber = patientPhoneNumber;
	}
	public String getPatientEmail() {
		return PatientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		PatientEmail = patientEmail;
	}
	public String getIsBeenHere() {
		return isBeenHere;
	}
	public void setIsBeenHere(String isBeenHere) {
		this.isBeenHere = isBeenHere;
	}
	
	
	@Override
	public String toString() {
		return "PatientRecord [PatientId=" + PatientId + ", PatientName=" + PatientName + ", PatientAge=" + PatientAge
				+ ", PatientGender=" + PatientGender + ", PatientAddress=" + PatientAddress + ", PatientCity="
				+ PatientCity + ", PatientZipCode=" + PatientZipCode + ", PatientDOB=" + PatientDOB
				+ ", PatientPhoneNumber=" + PatientPhoneNumber + ", PatientEmail=" + PatientEmail + ", isBeenHere="
				+ isBeenHere + "]";
	}
}
