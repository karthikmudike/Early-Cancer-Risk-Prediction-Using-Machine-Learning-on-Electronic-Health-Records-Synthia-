package com.karthikyadavmudike.learn_spring_boot.Doctors;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Doctors {
	
	@Id
	private long DoctorId;
	
	private String DoctorFirstName;
	
	private String DoctorLastName;
	
	private String Gender;
	
	private String PhoneNumber;
	
	private String Email;
	
	private String Department;

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public long getDoctorId() {
		return DoctorId;
	}

	public void setDoctorId(long doctorId) {
		DoctorId = doctorId;
	}

	public String getDoctorFirstName() {
		return DoctorFirstName;
	}

	public void setDoctorFirstName(String doctorFirstName) {
		DoctorFirstName = doctorFirstName;
	}

	public String getDoctorLastName() {
		return DoctorLastName;
	}

	public void setDoctorLastName(String doctorLastName) {
		DoctorLastName = doctorLastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Doctors [DoctorId=" + DoctorId + ", DoctorFirstName=" + DoctorFirstName + ", DoctorLastName="
				+ DoctorLastName + ", Gender=" + Gender + ", PhoneNumber=" + PhoneNumber + ", Email=" + Email
				+ ", Department=" + Department + "]";
	}
	
	
}
