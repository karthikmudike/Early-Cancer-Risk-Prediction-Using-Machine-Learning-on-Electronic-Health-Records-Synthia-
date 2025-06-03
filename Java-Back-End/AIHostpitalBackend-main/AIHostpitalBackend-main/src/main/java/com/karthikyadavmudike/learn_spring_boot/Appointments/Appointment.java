package com.karthikyadavmudike.learn_spring_boot.Appointments;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Appointment {
	
	@Id
	private long AppointmentId;
	
	private long PatientId;
	
	private String Reason;
	
	private Date appointmentDate;
	
	private String appointmentSlot;

	public long getAppointmentId() {
		return AppointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		AppointmentId = appointmentId;
	}

	public long getPatientId() {
		return PatientId;
	}

	public void setPatientId(long patientId) {
		PatientId = patientId;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentSlot() {
		return appointmentSlot;
	}

	public void setAppointmentSlot(String appointmentSlot) {
		this.appointmentSlot = appointmentSlot;
	}

	@Override
	public String toString() {
		return "Appointment [AppointmentId=" + AppointmentId + ", PatientId=" + PatientId + ", Reason=" + Reason
				+ ", appointmentDate=" + appointmentDate + ", appointmentSlot=" + appointmentSlot + "]";
	}
	
}
