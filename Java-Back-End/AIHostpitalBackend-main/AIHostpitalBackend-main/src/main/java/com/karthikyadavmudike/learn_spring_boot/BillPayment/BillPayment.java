package com.karthikyadavmudike.learn_spring_boot.BillPayment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BillPayment {
	
	@Id
	private long BillId;
	
	private String Description;
	
	private long Price;
	
	private long PatientId;

	public long getBillId() {
		return BillId;
	}

	public void setBillId(long billId) {
		BillId = billId;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public long getPrice() {
		return Price;
	}

	public void setPrice(long price) {
		Price = price;
	}

	public long getPatientId() {
		return PatientId;
	}

	public void setPatientId(long patientId) {
		PatientId = patientId;
	}

	@Override
	public String toString() {
		return "BillPayment [BillId=" + BillId + ", Description=" + Description + ", Price=" + Price + ", PatientId="
				+ PatientId + "]";
	}
	
	
}
