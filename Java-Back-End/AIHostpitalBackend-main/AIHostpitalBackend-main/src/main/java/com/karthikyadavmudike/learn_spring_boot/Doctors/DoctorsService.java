package com.karthikyadavmudike.learn_spring_boot.Doctors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorsService {
	
	@Autowired
	private DoctorsRepository repo;
	
	
	public List<Doctors> getDoctorReportByName(String name)
	{
		List<Doctors> list = this.repo.findAll();
		List<Doctors> res = new ArrayList<>();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getDoctorFirstName().toLowerCase().contains(name.toLowerCase())||list.get(i).getDoctorLastName().toLowerCase().contains(name.toLowerCase()))
			{
				res.add(list.get(i));
			}
		}
		return res;
	}

}
