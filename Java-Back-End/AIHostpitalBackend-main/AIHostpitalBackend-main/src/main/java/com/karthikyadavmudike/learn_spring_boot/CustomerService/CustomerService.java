package com.karthikyadavmudike.learn_spring_boot.CustomerService;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerService {
	
	@Id
	private long CustomerId;
	
	private String CustomerName;
	
	private String CustomerLName;
	
	private String PhoneNumber;
	
	private String Email;
	
	private String Message;

	public CustomerService(){}

	public long getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(long customerId) {
		CustomerId = customerId;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerLName() {
		return CustomerLName;
	}

	public void setCustomerLName(String customerLName) {
		CustomerLName = customerLName;
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

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "CustomerService [CustomerId=" + CustomerId + ", CustomerName=" + CustomerName + ", CustomerLName="
				+ CustomerLName + ", PhoneNumber=" + PhoneNumber + ", Email=" + Email + ", Message=" + Message + "]";
	}
	
	

}
