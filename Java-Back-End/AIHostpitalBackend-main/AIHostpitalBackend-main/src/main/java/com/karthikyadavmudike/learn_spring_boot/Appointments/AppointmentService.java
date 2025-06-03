package com.karthikyadavmudike.learn_spring_boot.Appointments;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository repo;
	
	List<Appointment> getAllDataByAppointmentId(long Id)
	{
		List<Appointment> list = this.repo.findAll();
		List<Appointment> list1 = new ArrayList<>();
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getPatientId()==Id)
			{
				list1.add(list.get(i));
			}
		}
		
		return list1;
	}

}
