package com.karthikyadavmudike.learn_spring_boot.BillPayment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillPaymentService {
	
	@Autowired
	private BillPaymentRepository repo;
	
	public List<BillPayment> getAllBillsById(long Id)
	{
		List<BillPayment> list = new ArrayList<>();
		List<BillPayment> data = this.repo.findAll();		
		for(int i=0;i<data.size();i++)
		{
			if(data.get(i).getPatientId()==Id)
			{
				list.add(data.get(i));
			}
		}
		return list;
	}
	
	public void deleteTheList(long Id)
	{
		List<BillPayment> data = this.repo.findAll();
		
		for(int i=0;i<data.size();i++)
		{
			if(data.get(i).getPatientId()==Id)
			{
				this.repo.delete(data.get(i));
			}
		}
	}
	

}
